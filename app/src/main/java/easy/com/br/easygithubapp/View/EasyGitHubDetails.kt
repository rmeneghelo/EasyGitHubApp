package easy.com.br.easygithubapp.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import easy.com.br.easygithubapp.Application.GetRepositoryDetailsHandler
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.di.modules.Components.DaggerGetRepositoryDetailsHandlerComponent
import easy.com.br.easygithubapp.di.modules.Components.GetRepositoryDetailsHandlerComponent
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EasyGitHubDetails: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub_details)

        Toast.makeText(applicationContext,"Clicked on item ${intent.getStringExtra("authorName") }" +
                "${intent.getStringExtra("repositoryName") }", Toast.LENGTH_LONG).show()

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

                        },
                        {
                            e -> Log.d("Repository Details erro", e.message)
                        },
                        {

                        }
                )
    }
}