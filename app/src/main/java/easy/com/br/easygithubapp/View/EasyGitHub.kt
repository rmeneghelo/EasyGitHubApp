package easy.com.br.easygithubapp.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import easy.com.br.easygithubapp.Adapters.RepositoriesAdapter
import easy.com.br.easygithubapp.R
import kotlinx.android.synthetic.main.activity_easy_git_hub.*
import android.support.v7.widget.DividerItemDecoration
import android.util.Log
import easy.com.br.easygithubapp.Application.GetRepositoriesHandler
import easy.com.br.easygithubapp.Model.Repository
import easy.com.br.easygithubapp.di.modules.Components.DaggerGetRepositoriesHandlerComponent
import easy.com.br.easygithubapp.di.modules.Components.GetRepositoriesHandlerComponent
import easy.com.br.easygithubapp.di.modules.GetRepositoriesHandlerModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EasyGitHub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub)

        var component: GetRepositoriesHandlerComponent = DaggerGetRepositoriesHandlerComponent
                .builder()
                .getRepositoriesHandlerModule(GetRepositoriesHandlerModule())
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
                            Log.d("Xuxa tentativa 1", result.items.size.toString())
                            FillingRepositoriesView(result.items)
                        },
                        {
                            e -> Log.d("Xuxa tentativa erro", e.message)
                        },
                        {
                            repositories_recycler_view.adapter.notifyDataSetChanged()
                        }
                )
    }

    private fun FillingRepositoriesView(repositoriesList: List<Repository>){
        val mLayoutManager = LinearLayoutManager(applicationContext)
        repositories_recycler_view.layoutManager = mLayoutManager
        repositories_recycler_view.itemAnimator = DefaultItemAnimator()
        repositories_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        repositories_recycler_view.adapter = RepositoriesAdapter(repositoriesList){}
    }

}
