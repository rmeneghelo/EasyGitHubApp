package easy.com.br.easygithubapp.view

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
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import easy.com.br.easygithubapp.di.modules.components.DaggerGetRepositoriesHandlerComponent
import easy.com.br.easygithubapp.di.modules.components.GetRepositoriesHandlerComponent
import easy.com.br.easygithubapp.domain.model.RepositoryDto
import easy.com.br.easygithubapp.view.feed.adapter.RepositoriesAdapter
import easy.com.br.easygithubapp.viewModel.GetRepositoriesHandler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_easy_git_hub.*


class EasyGitHub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub)

        val component: GetRepositoriesHandlerComponent = DaggerGetRepositoriesHandlerComponent
                .builder()
                .gitHubRepositoryModule(GitHubRepositoryModule())
                .retrofitModule(RetrofitModule())
                .build()

        val handler : GetRepositoriesHandler = component.getRepositoriesHandler()

        getRepositories(handler)

        swipeRefresh.setOnRefreshListener {
            getRepositories(handler)
            onItemsLoadComplete()
        }
    }

    private fun fillingRepositoriesView(repository: RepositoryDto){
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

    private fun getRepositories(handler: GetRepositoriesHandler){
        handler.getRepositories()

        handler
                .repositoriesResult
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            Log.d("Result size: ", result.listRepositories.size.toString())
                            fillingRepositoriesView(result)
                            fillingTotalRepositories(result)
                            fillingTotalOpenIssues(result)
                        },
                        {
                            e -> Log.d("Error EasyGitHubApp:", e.message)
                        },
                        {
                            repositories_recycler_view.adapter?.notifyDataSetChanged()
                        }
                )
    }

    private fun fillingTotalOpenIssues(result: RepositoryDto?) {
        tvTotalIssues.text = getString(R.string.totalIssuesText)
        val totalCount = SpannableString(result?.openIssuesMoreThanHundred.toString())

        totalCount.let {
            totalCount.setSpan(ForegroundColorSpan(Color.rgb(255,165,0)), 0, it.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            tvTotalIssues.append(" $it")
        }
    }

    private fun fillingTotalRepositories(result: RepositoryDto?) {
        tvTotal.text = getString(R.string.totalOfRepositoriesText)
        val totalCount = SpannableString(result?.totalCount.toString())

        totalCount.let {
            totalCount.setSpan(ForegroundColorSpan(Color.rgb(255,165,0)), 0, it.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            tvTotal.append(" $it")
        }
    }

    private fun onItemsLoadComplete() {
        swipeRefresh.isRefreshing = false
    }
}
