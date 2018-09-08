package easy.com.br.easygithubapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import easy.com.br.easygithubapp.domain.model.*
import easy.com.br.easygithubapp.repository.GitHubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetRepositoriesViewModel @Inject constructor(private val repository: GitHubRepository) : ViewModel() {

    val errorData = MutableLiveData<Boolean>()
    val loadingData = MutableLiveData<Boolean>()
    val repositoriesData = MutableLiveData<List<UserRepository>>()

    fun getRepositories() {
        repository.getRepositories(repositoriesCallback())
    }

    private fun repositoriesCallback() = object : Callback<RepositoriesApiResult> {
        override fun onFailure(call: Call<RepositoriesApiResult>?, t: Throwable?) {
            loadingData.value = false
            errorData.value = true
        }

        override fun onResponse(call: Call<RepositoriesApiResult>?, response: Response<RepositoriesApiResult>?) {
            loadingData.value = false
            errorData.value = false

            response?.body()?.run {
                val result = mapResult(this)
                updateData(result)
            }
        }
    }

    private fun mapResult(result: RepositoriesApiResult): List<UserRepository> {
        val userRepository = arrayListOf<UserRepository>()
        result.items.forEach {
            userRepository.add(UserRepository(it.githubRepositoryName,
                    it.description,
                    RepositoryOwner(it.owner.authorName, it.owner.authorPhoto),
                    checkApacheLicense(it.license),
                    it.starsNumber,
                    it.forksNumber,
                    it.openIssuesNumber))
        }

        return userRepository
    }

    private fun updateData(data: List<UserRepository>) {
        repositoriesData.postValue(data)
    }

    fun onRefresh() {
        getRepositories()
    }

    private fun checkOpenIssuesMoreThanHundred(repositoriesList: List<UserRepository>): Int {
        return repositoriesList.count { repository -> repository.openIssuesNumber > 100 }
    }

    private fun checkApacheLicense(license: License?): RepositoryLicense {
        var isApache = false

        license?.licenseKey?.let {
            if (it.contains("Apache", true)) {
                isApache = true
            }
        }

        return RepositoryLicense(isApache)
    }

}