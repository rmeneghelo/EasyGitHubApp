package easy.com.br.easygithubapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.domain.model.UserRepositoryDetail
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import javax.inject.Inject

class GetRepositoryDetailsViewModel @Inject constructor(private val repository: GitHubDetailsRepository) : ViewModel() {
    private val userRepositoryDetailInput = MutableLiveData<UserRepositoryDetail>()
    val errorData = MutableLiveData<Boolean>()
    val loadingData = MutableLiveData<Boolean>()
    val repositoryDetailData: LiveData<MutableList<RepositoryDetail>> = Transformations.switchMap(userRepositoryDetailInput) {
        repository.getRepositoryDetails(it)
    }

    fun getRepositoryDetails(userRepositoryDetail: UserRepositoryDetail) {
        loadingData.postValue(true)
        userRepositoryDetailInput.value = userRepositoryDetail
        loadingData.postValue(false)
    }
}