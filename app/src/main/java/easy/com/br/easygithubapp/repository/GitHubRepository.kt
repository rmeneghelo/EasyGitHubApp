package easy.com.br.easygithubapp.repository

import android.arch.lifecycle.MutableLiveData
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult

interface GitHubRepository {
    fun getRepositories(result: MutableLiveData<RepositoriesApiResult>)
}
