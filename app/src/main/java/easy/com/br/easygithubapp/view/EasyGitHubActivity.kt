package easy.com.br.easygithubapp.view

import android.arch.lifecycle.Observer
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
import android.view.View
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.components.DaggerGetRepositoriesHandlerComponent
import easy.com.br.easygithubapp.di.modules.components.GetRepositoriesHandlerComponent
import easy.com.br.easygithubapp.domain.model.RepositoryDto
import easy.com.br.easygithubapp.domain.model.UserRepository
import easy.com.br.easygithubapp.view.feed.adapter.RepositoriesAdapter
import easy.com.br.easygithubapp.viewmodel.GetRepositoriesViewModel
import kotlinx.android.synthetic.main.activity_easy_git_hub.*

class EasyGitHubActivity : AppCompatActivity() {

    private lateinit var repoAdapter: RepositoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub)

        val component: GetRepositoriesHandlerComponent = DaggerGetRepositoriesHandlerComponent
                .builder()
                .gitHubRepositoryModule(GitHubRepositoryModule())
                .build()

        repoAdapter = RepositoriesAdapter {
            val intent = Intent(this@EasyGitHubActivity, EasyGitHubDetailsActivity::class.java)

            intent.putExtra("authorName", it.owner.authorName)
            intent.putExtra("repositoryName", it.githubRepositoryName)
            startActivity(intent)
        }

        val viewModel: GetRepositoriesViewModel = component.getRepositoriesViewModel()

        fillingRepositoriesView()

        viewModel
                .repositoriesData
                .observe(this, Observer<List<UserRepository>> { t -> fillRepo(t) })

        viewModel.errorData.observe(this, Observer { it?.let { setErrorVisibility(it) } })

        viewModel.loadingData.observe(this, Observer { it?.let { showLoading(it) } })

        swipeRefresh.setOnRefreshListener(viewModel::onRefresh)

        viewModel.getRepositories()
    }
    private fun fillRepo(list: List<UserRepository>?) {
        list?.let {
            repoAdapter.addItems(it)
        }
    }


    private fun fillingRepositoriesView() {
        val mLayoutManager = LinearLayoutManager(applicationContext)
        repositories_recycler_view.layoutManager = mLayoutManager
        repositories_recycler_view.itemAnimator = DefaultItemAnimator()
        repositories_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        repositories_recycler_view.adapter = repoAdapter
    }

    private fun showLoading(isLoading: Boolean) {
        swipeRefresh.isRefreshing = isLoading
    }

    private fun setErrorVisibility(shouldShow: Boolean) {
        error_view.visibility = if (shouldShow) View.VISIBLE else View.GONE
        repositories_recycler_view.visibility = if (!shouldShow) View.VISIBLE else View.GONE
    }

    private fun fillingTotalOpenIssues(result: RepositoryDto?) {
        tvTotalIssues.text = getString(R.string.totalIssuesText)
        val totalCount = SpannableString(result?.openIssuesMoreThanHundred.toString())

        totalCount.let {
            totalCount.setSpan(ForegroundColorSpan(Color.rgb(255, 165, 0)), 0, it.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            tvTotalIssues.append(" $it")
        }
    }

    private fun fillingTotalRepositories(result: RepositoryDto?) {
        tvTotal.text = getString(R.string.totalOfRepositoriesText)
        val totalCount = SpannableString(result?.totalCount.toString())

        totalCount.let {
            totalCount.setSpan(ForegroundColorSpan(Color.rgb(255, 165, 0)), 0, it.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            tvTotal.append(" $it")
        }
    }

    private fun onItemsLoadComplete() {
        swipeRefresh.isRefreshing = false
    }
}
