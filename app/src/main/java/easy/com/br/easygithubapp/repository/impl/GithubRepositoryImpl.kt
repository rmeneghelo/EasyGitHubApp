package easy.com.br.easygithubapp.repository.impl

import android.arch.lifecycle.MutableLiveData
import easy.com.br.easygithubapp.domain.interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import easy.com.br.easygithubapp.repository.GitHubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : GitHubRepository {
    private var result =  MutableLiveData<RepositoriesApiResult>()

    override fun getRepositories(): MutableLiveData<RepositoriesApiResult> {
        val service = retrofit
                .create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        service.searchNew().enqueue(object : Callback<RepositoriesApiResult> {
            override fun onResponse(call: Call<RepositoriesApiResult>?, response: Response<RepositoriesApiResult>?) {
                response?.body()?.let {
                    result.postValue(it)
                }
            }

            override fun onFailure(call: Call<RepositoriesApiResult>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

        return result
    }
}