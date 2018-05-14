package easy.com.br.easygithubapp.View

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import easy.com.br.easygithubapp.Adapters.RepositoriesAdapter
import easy.com.br.easygithubapp.Application.GetRepositoriesHandler
import easy.com.br.easygithubapp.Domain.Model.RepositoryDto
import easy.com.br.easygithubapp.R
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

        GetRepositories(handler)

        swipeRefresh.setOnRefreshListener {
            GetRepositories(handler)
            onItemsLoadComplete()
        }
    }

    private fun FillingRepositoriesView(repository: RepositoryDto){
        val mLayoutManager = LinearLayoutManager(applicationContext)
        repositories_recycler_view.layoutManager = mLayoutManager
        repositories_recycler_view.itemAnimator = DefaultItemAnimator()
        repositories_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        repositories_recycler_view.adapter = RepositoriesAdapter(repository.listRepositories){
            val intent = Intent(this@EasyGitHub, EasyGitHubDetails::class.java)

            intent.putExtra("authorName", it.owner.authorName)
            intent.putExtra("repositoryName", it.githubRepositoryName)
            startActivity(intent)
        }
    }

    private fun GetRepositories(handler: GetRepositoriesHandler){
        handler.GetRepositories()

        handler
                .repositoriesResult
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            Log.d("Xuxa tentativa 1", result.listRepositories.size.toString())
                            FillingRepositoriesView(result)
                            FillingTotalRepositories(result)
                            FillingTotalOpenIssues(result)
                        },
                        {
                            e -> Log.d("Xuxa tentativa erro", e.message)
                        },
                        {
                            repositories_recycler_view.adapter.notifyDataSetChanged()
                        }
                )
    }

    private fun FillingTotalOpenIssues(result: RepositoryDto?) {
        tvTotalIssues.text = "Repositories with more than 100 open issues: "
        val totalCount = SpannableString(result?.openIssuesMoreThanHundred.toString())

        totalCount.setSpan(ForegroundColorSpan(Color.rgb(255,165,0)), 0, totalCount.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvTotalIssues.append(totalCount)
    }

    private fun FillingTotalRepositories(result: RepositoryDto?) {
        tvTotal.text = "Total of repositories: "
        val totalCount = SpannableString(result?.totalCount.toString())

        totalCount.setSpan(ForegroundColorSpan(Color.rgb(255,165,0)), 0, totalCount.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvTotal.append(totalCount)
    }

    fun onItemsLoadComplete() {
        swipeRefresh.isRefreshing = false
    }
}
