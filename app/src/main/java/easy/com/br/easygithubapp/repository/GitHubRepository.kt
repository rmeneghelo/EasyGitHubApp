package easy.com.br.easygithubapp.repository

import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import io.reactivex.Observable

interface GitHubRepository{
    fun getRepositories() : Observable<RepositoriesApiResult>
}
