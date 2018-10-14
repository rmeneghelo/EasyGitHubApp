package easy.com.br.easygithubapp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import easy.com.br.easygithubapp.domain.model.*
import easy.com.br.easygithubapp.repository.GitHubRepository
import javax.inject.Inject

class GetRepositoriesViewModel @Inject constructor(private val repository: GitHubRepository) : ViewModel() {
    private var apiResultData = MutableLiveData<String>()
    val errorData = MutableLiveData<Boolean>()
    val loadingData = MutableLiveData<Boolean>()
    private val repositoriesData: LiveData<RepositoriesApiResult> = Transformations.switchMap(apiResultData) {
        repository.getRepositories()
    }

    val repositoriesData2: LiveData<List<UserRepository>> = Transformations.switchMap(repositoriesData) {
        MutableLiveData<List<UserRepository>>().apply {
            postValue(mapResult(it))
        }
    }

    fun getRepositories() {
        apiResultData.value = ""
    }

    private fun mapResult(result: RepositoriesApiResult): List<UserRepository> {
        val userRepository = mutableListOf<UserRepository>()

        result.let {
            it.items.forEach {
                userRepository.add(UserRepository(it.githubRepositoryName,
                        it.description,
                        RepositoryOwner(it.owner.authorName, it.owner.authorPhoto),
                        checkApacheLicense(it.license),
                        it.starsNumber,
                        it.forksNumber,
                        it.openIssuesNumber))
            }
        }

        return userRepository
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