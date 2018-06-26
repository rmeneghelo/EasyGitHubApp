package easy.com.br.easygithubapp.repository

import easy.com.br.easygithubapp.Model.RepositoriesApiResult
import io.reactivex.Observable

interface GitHubRepository{
    fun GetRepositories() : Observable<RepositoriesApiResult>
}
