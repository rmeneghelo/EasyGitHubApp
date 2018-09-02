package easy.com.br.easygithubapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import easy.com.br.easygithubapp.di.modules.components.DaggerGetRepositoryDetailsHandlerComponent
import easy.com.br.easygithubapp.di.modules.components.GetRepositoryDetailsHandlerComponent
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.view.feed.adapter.RepositoryDetailsAdapter
import easy.com.br.easygithubapp.viewModel.GetRepositoryDetailsViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_easy_git_hub_details.*

class EasyGitHubDetails: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub_details)

        val component: GetRepositoryDetailsHandlerComponent = DaggerGetRepositoryDetailsHandlerComponent
                .builder()
                .gitHubRepositoryModule(GitHubRepositoryModule())
                .retrofitModule(RetrofitModule())
                .build()

        val viewModel : GetRepositoryDetailsViewModel = component.getRepositoryDetailsViewModel()

        getRepositoryDetails(viewModel, intent.getStringExtra("authorName"), intent.getStringExtra("repositoryName"))
    }

    private fun getRepositoryDetails(viewModel: GetRepositoryDetailsViewModel,
                                     username: String,
                                     repositoryName: String){

        viewModel.getRepositoryDetails(username, repositoryName)

        viewModel
                .repositoryDetailsResult
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            Log.d("repository Details view", result.size.toString())
                            fillingRepositoriesView(result)
                        },
                        {
                            e -> Log.d("repository Details erro", e.message)
                        },
                        {

                        }
                )
    }

    private fun fillingRepositoriesView(repositoryDetail: List<RepositoryDetail>){
        val mLayoutManager = LinearLayoutManager(applicationContext)
        repository_detail_recycler_view.layoutManager = mLayoutManager
        repository_detail_recycler_view.itemAnimator = DefaultItemAnimator()
        repository_detail_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        repository_detail_recycler_view.adapter = RepositoryDetailsAdapter(repositoryDetail)
    }
}