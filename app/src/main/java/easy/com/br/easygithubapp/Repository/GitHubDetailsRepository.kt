package easy.com.br.easygithubapp.Repository

import easy.com.br.easygithubapp.Domain.Model.RepositoryDetail
import io.reactivex.Observable

interface GitHubDetailsRepository{
    fun GetRepositoryDetails(username: String,
                             repositoryName: String) : Observable<List<RepositoryDetail>>
}