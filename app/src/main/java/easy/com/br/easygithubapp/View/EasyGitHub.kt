package easy.com.br.easygithubapp.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import easy.com.br.easygithubapp.Adapters.RepositoriesAdapter
import easy.com.br.easygithubapp.R
import android.support.v7.widget.DividerItemDecoration
import android.util.Log
import easy.com.br.easygithubapp.Application.GetRepositoriesHandler
import easy.com.br.easygithubapp.Domain.Model.RepositoryDto
import easy.com.br.easygithubapp.di.modules.Components.DaggerGetRepositoriesHandlerComponent
import easy.com.br.easygithubapp.di.modules.Components.GetRepositoriesHandlerComponent
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_easy_git_hub.*

class EasyGitHub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub)

        var component: GetRepositoriesHandlerComponent = DaggerGetRepositoriesHandlerComponent
                .builder()
                .gitHubRepositoryModule(GitHubRepositoryModule())
                .retrofitModule(RetrofitModule())
                .build()

        val handler : GetRepositoriesHandler = component.getRepositoriesHandler()

        handler.GetRepositories()

        handler
                .repositoriesResult
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            Log.d("Xuxa tentativa 1", result.size.toString())
                            FillingRepositoriesView(result)
                        },
                        {
                            e -> Log.d("Xuxa tentativa erro", e.message)
                        },
                        {
                            repositories_recycler_view.adapter.notifyDataSetChanged()
                        }
                )
    }

    private fun FillingRepositoriesView(repositoriesList: List<RepositoryDto>){

        val mLayoutManager = LinearLayoutManager(applicationContext)
        repositories_recycler_view.layoutManager = mLayoutManager
        repositories_recycler_view.itemAnimator = DefaultItemAnimator()
        repositories_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        repositories_recycler_view.adapter = RepositoriesAdapter(repositoriesList){
            val intent = Intent(this@EasyGitHub, EasyGitHubDetails::class.java)

            intent.putExtra("repositoryId", it.githubRepositoryName)
            startActivity(intent)
        }
    }
}
