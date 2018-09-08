package easy.com.br.easygithubapp.repository

import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import retrofit2.Callback

interface GitHubRepository {
    fun getRepositoriesNew(callback: Callback<RepositoriesApiResult>)
}
