package easy.com.br.easygithubapp.repository.impl

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import easy.com.br.easygithubapp.domain.interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.domain.model.ErrorResult
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import easy.com.br.easygithubapp.domain.model.Result
import easy.com.br.easygithubapp.domain.model.ValueResult
import easy.com.br.easygithubapp.repository.GitHubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : GitHubRepository {
    override fun getRepositories(): LiveData<Result<RepositoriesApiResult, String>> {
        val result = MutableLiveData<Result<RepositoriesApiResult, String>>()
        val service = retrofit
                .create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        service.search().enqueue(object : Callback<RepositoriesApiResult> {
            override fun onResponse(call: Call<RepositoriesApiResult>?, response: Response<RepositoriesApiResult>?) {
                response?.body()?.let {
                    result.value = ValueResult(it)
                }
            }

            override fun onFailure(call: Call<RepositoriesApiResult>?, t: Throwable?) {
                result.value = ErrorResult(t?.message ?: "")
            }

        })

        return result
    }
}