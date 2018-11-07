package easy.com.br.easygithubapp.view

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import easy.com.br.easygithubapp.di.modules.components.DaggerGetRepositoryDetailsHandlerComponent
import easy.com.br.easygithubapp.di.modules.components.GetRepositoryDetailsHandlerComponent
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.domain.model.UserRepositoryDetail
import easy.com.br.easygithubapp.view.feed.adapter.RepositoryDetailsAdapter
import easy.com.br.easygithubapp.viewmodel.GetRepositoryDetailsViewModel
import kotlinx.android.synthetic.main.activity_easy_git_hub_details.*

class EasyGitHubDetailsActivity : AppCompatActivity() {
    private lateinit var repositoryDetailAdapter: RepositoryDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub_details)

        val component: GetRepositoryDetailsHandlerComponent = DaggerGetRepositoryDetailsHandlerComponent
                .builder()
                .gitHubRepositoryModule(GitHubRepositoryModule())
                .retrofitModule(RetrofitModule())
                .build()

        repositoryDetailAdapter = RepositoryDetailsAdapter()

        val viewModel: GetRepositoryDetailsViewModel = component.getRepositoryDetailsViewModel()

        fillingRepositoriesView()

        viewModel
                .repositoryDetailData
                .observe(this, Observer {
                    fillRepo(it)
                })

        viewModel.errorData.observe(this, Observer { it?.let { setErrorVisibility(it) } })

        getRepositoryDetails(viewModel, intent.getStringExtra("authorName"), intent.getStringExtra("repositoryName"))
    }

    private fun getRepositoryDetails(viewModel: GetRepositoryDetailsViewModel,
                                     username: String,
                                     repositoryName: String) {

        viewModel.getRepositoryDetails(UserRepositoryDetail(username, repositoryName))
    }

    private fun fillingRepositoriesView() {
        val mLayoutManager = LinearLayoutManager(applicationContext)
        repository_detail_recycler_view.layoutManager = mLayoutManager
        repository_detail_recycler_view.itemAnimator = DefaultItemAnimator()
        repository_detail_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        repository_detail_recycler_view.adapter = repositoryDetailAdapter
    }

    private fun fillRepo(list: List<RepositoryDetail>?) {
        list?.let {
            repositoryDetailAdapter.addItems(it)
        }
    }

    private fun setErrorVisibility(shouldShow: Boolean) {
        error_view.visibility = if (shouldShow) View.VISIBLE else View.GONE
        repository_detail_recycler_view.visibility = if (!shouldShow) View.VISIBLE else View.GONE
    }
}