package easy.com.br.easygithubapp.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.domain.model.HeaderDto
import easy.com.br.easygithubapp.domain.model.UserRepository
import easy.com.br.easygithubapp.view.feed.adapter.RepositoriesAdapter
import easy.com.br.easygithubapp.viewmodel.GetRepositoriesViewModel
import kotlinx.android.synthetic.main.activity_easy_git_hub.*
import javax.inject.Inject

class EasyGitHubActivity : DaggerAppCompatActivity() {

    private lateinit var repoAdapter: RepositoriesAdapter

    @Inject
    lateinit var viewModel: GetRepositoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub)

        repoAdapter = RepositoriesAdapter {
            val intent = Intent(this@EasyGitHubActivity, EasyGitHubDetailsActivity::class.java)

            intent.putExtra("authorName", it.owner.authorName)
            intent.putExtra("repositoryName", it.githubRepositoryName)
            startActivity(intent)
        }

        fillingRepositoriesView()

        viewModel
                .repositoriesData
                .observe(this, Observer<List<UserRepository>> { repositoriesList -> fillRepo(repositoriesList) })

        viewModel
                .headerData
                .observe(this, Observer<HeaderDto> { header -> fillHeader(header) })

        viewModel.errorData.observe(this, Observer { errorData -> errorData?.let { setErrorVisibility(it) } })

        viewModel.loadingData.observe(this, Observer { loading -> loading?.let { showLoading(it) } })

        swipeRefresh.setOnRefreshListener(viewModel::onRefresh)

        viewModel.getRepositories()
    }
    private fun fillRepo(list: List<UserRepository>?) {
        list?.let {
            repoAdapter.addItems(it)
        }
    }

    private fun fillHeader(header: HeaderDto?) {
        header?.let {
            fillingTotalRepositories(it.totalRepositories)
            fillingTotalOpenIssues(it.totalMoreThanHundredOpenIssues)
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

    private fun fillingTotalOpenIssues(result: Int) {
        val text = getString(R.string.totalIssuesText)
        SpannableString(text + result.toString()).apply {
            this.setSpan(ForegroundColorSpan(Color.rgb(255, 165, 0)), text.length, this.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }.also {
            tvTotalIssues.text = it
        }


    }

    private fun fillingTotalRepositories(result: Int) {
        val text = getString(R.string.totalOfRepositoriesText)
        SpannableString(text + result.toString()).apply {
            this.setSpan(ForegroundColorSpan(Color.rgb(255, 165, 0)), text.length, this.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }.also {
            tvTotal.text = it
        }
    }
}
