package easy.com.br.easygithubapp.repository

import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import io.reactivex.Observable
import retrofit2.Callback

interface GitHubRepository {
    fun getRepositories(): Observable<RepositoriesApiResult>
    fun getRepositoriesNew(callback: Callback<RepositoriesApiResult>)
}
