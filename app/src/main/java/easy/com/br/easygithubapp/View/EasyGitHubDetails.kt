package easy.com.br.easygithubapp.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import easy.com.br.easygithubapp.Adapters.RepositoryDetailsAdapter
import easy.com.br.easygithubapp.Application.GetRepositoryDetailsHandler
import easy.com.br.easygithubapp.Domain.Model.RepositoryDetail
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.di.modules.Components.DaggerGetRepositoryDetailsHandlerComponent
import easy.com.br.easygithubapp.di.modules.Components.GetRepositoryDetailsHandlerComponent
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_easy_git_hub_details.*

class EasyGitHubDetails: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub_details)

        var component: GetRepositoryDetailsHandlerComponent = DaggerGetRepositoryDetailsHandlerComponent
                .builder()
                .gitHubRepositoryModule(GitHubRepositoryModule())
                .retrofitModule(RetrofitModule())
                .build()

        val handler : GetRepositoryDetailsHandler = component.getRepositoryDetailsHandler()

        GetRepositoryDetails(handler, intent.getStringExtra("authorName"), intent.getStringExtra("repositoryName"))
    }

    private fun GetRepositoryDetails(handler: GetRepositoryDetailsHandler,
                                     username: String,
                                     repositoryName: String){

        handler.GetRepositoryDetails(username, repositoryName)

        handler
                .repositoryDetailsResult
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            Log.d("Repository Details View", result.size.toString())
                            FillingRepositoriesView(result)
                        },
                        {
                            e -> Log.d("Repository Details erro", e.message)
                        },
                        {

                        }
                )
    }

    private fun FillingRepositoriesView(repositoryDetail: List<RepositoryDetail>){
        val mLayoutManager = LinearLayoutManager(applicationContext)
        repository_detail_recycler_view.layoutManager = mLayoutManager
        repository_detail_recycler_view.itemAnimator = DefaultItemAnimator()
        repository_detail_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        repository_detail_recycler_view.adapter = RepositoryDetailsAdapter(repositoryDetail)
    }
}