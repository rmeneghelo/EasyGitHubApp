package easy.com.br.easygithubapp.repository

import android.arch.lifecycle.MutableLiveData
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import retrofit2.Callback

interface GitHubRepository {
    fun getRepositories(): MutableLiveData<RepositoriesApiResult>
}
