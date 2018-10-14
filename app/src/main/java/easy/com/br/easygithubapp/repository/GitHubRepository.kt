package easy.com.br.easygithubapp.repository

import android.arch.lifecycle.LiveData
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult

interface GitHubRepository {
    fun getRepositories(): LiveData<RepositoriesApiResult>
}
