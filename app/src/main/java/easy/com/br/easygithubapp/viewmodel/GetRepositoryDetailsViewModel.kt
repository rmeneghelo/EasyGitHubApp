package easy.com.br.easygithubapp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.view.animation.Transformation
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.domain.model.UserRepository
import easy.com.br.easygithubapp.domain.model.UserRepositoryDetail
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetRepositoryDetailsViewModel @Inject constructor(private val repository: GitHubDetailsRepository) : ViewModel() {
    private val userRepositoryDetailInput = MutableLiveData<UserRepositoryDetail>()
    val errorData = MutableLiveData<Boolean>()
    val loadingData = MutableLiveData<Boolean>()
    val repositoryDetailData: LiveData<List<RepositoryDetail>> = Transformations.switchMap(userRepositoryDetailInput) {
        repository.getRepositoryDetails(it)
    }

    fun getRepositoryDetails(userRepositoryDetail: UserRepositoryDetail) {
        loadingData.postValue(true)
        userRepositoryDetailInput.value = userRepositoryDetail
        loadingData.postValue(false)
    }
}