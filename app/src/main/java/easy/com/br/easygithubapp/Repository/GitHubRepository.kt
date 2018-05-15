package easy.com.br.easygithubapp.Repository

import easy.com.br.easygithubapp.Model.RepositoriesApiResult
import io.reactivex.Observable

interface GitHubRepository{
    fun GetRepositories() : Observable<RepositoriesApiResult>
}
