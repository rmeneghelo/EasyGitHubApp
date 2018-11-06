package easy.com.br.easygithubapp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import easy.com.br.easygithubapp.domain.model.*
import easy.com.br.easygithubapp.repository.GitHubRepository
import javax.inject.Inject

class GetRepositoriesViewModel @Inject constructor(private val repository: GitHubRepository) : ViewModel() {
    val errorData = MutableLiveData<Boolean>()
    val loadingData = MutableLiveData<Boolean>()
    private var apiResultData = MutableLiveData<String>()
    private val repositoriesApiResultData: LiveData<Result<RepositoriesApiResult, String>> = Transformations.switchMap(apiResultData) {
        repository.getRepositories().apply {
            loadingData.value = true
        }
    }

    val repositoriesData: LiveData<List<UserRepository>> = Transformations.switchMap(repositoriesApiResultData) {
        MutableLiveData<List<UserRepository>>().apply {
            if (it is ValueResult) {
                postValue(mapResult(it.value))
            } else {
                errorData.value = true
            }
        }
    }

    val headerData: LiveData<HeaderDto> = Transformations.switchMap(repositoriesData) {
        MutableLiveData<HeaderDto>().apply {
            postValue(mapResultHeaderDto(it))

            loadingData.value = false
        }
    }

    fun getRepositories() {
        apiResultData.value = ""
    }

    private fun mapResult(result: RepositoriesApiResult): List<UserRepository> {
        val userRepository = mutableListOf<UserRepository>()

        result.let { apiResult ->
            apiResult.items.forEach {
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

    private fun mapResultHeaderDto(userRepository: List<UserRepository>): HeaderDto {
        var headerDto: HeaderDto

        userRepository.let { listOfUsers ->
            headerDto = HeaderDto().apply {
                totalRepositories = listOfUsers.count()
                totalMoreThanHundredOpenIssues = checkOpenIssuesMoreThanHundred(listOfUsers)
            }
        }

        return headerDto
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