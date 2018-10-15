package easy.com.br.easygithubapp.repository.impl

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import easy.com.br.easygithubapp.domain.interfaces.IGitHubRepositoryDetailsService
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.domain.model.UserRepositoryDetail
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class GitHubDetailsRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : GitHubDetailsRepository {
    override fun getRepositoryDetails(userRepositoryDetail: UserRepositoryDetail): LiveData<MutableList<RepositoryDetail>> {
        val result = MutableLiveData<MutableList<RepositoryDetail>>()
        val service = retrofit
                .create<IGitHubRepositoryDetailsService>(IGitHubRepositoryDetailsService::class.java)
        service
                .details(userRepositoryDetail.username, userRepositoryDetail.repositoryName)
                .enqueue(object : Callback<MutableList<RepositoryDetail>> {
                    override fun onFailure(call: Call<MutableList<RepositoryDetail>>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<MutableList<RepositoryDetail>>?, response: Response<MutableList<RepositoryDetail>>?) {
                        response?.body()?.run {
                            result.value = this
                        }
                    }
                })

        return result
    }
}