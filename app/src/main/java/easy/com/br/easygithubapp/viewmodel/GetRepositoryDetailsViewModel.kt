package easy.com.br.easygithubapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetRepositoryDetailsViewModel @Inject constructor(private val repository: GitHubDetailsRepository): ViewModel() {

    val errorData = MutableLiveData<Boolean>()
    val loadingData = MutableLiveData<Boolean>()
    val repositoryDetailData = MutableLiveData<List<RepositoryDetail>>()

    fun getRepositoryDetails(username: String, repositoryName: String) {
        repository
                .getRepositoryDetails(username, repositoryName, repositoryDetailCallBack())
    }

    private fun repositoryDetailCallBack() = object : Callback<List<RepositoryDetail>> {
        override fun onFailure(call: Call<List<RepositoryDetail>>?, t: Throwable?) {
            loadingData.value = false
            errorData.value = true
        }

        override fun onResponse(call: Call<List<RepositoryDetail>>?, response: Response<List<RepositoryDetail>>?) {
            loadingData.value = false
            errorData.value = false

            response?.body()?.run {
                updateData(this)
            }
        }
    }

    private fun updateData(data: List<RepositoryDetail>) {
        repositoryDetailData.postValue(data)
    }
}