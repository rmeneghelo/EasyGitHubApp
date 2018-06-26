package easy.com.br.easygithubapp.repository

import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import io.reactivex.Observable

interface GitHubDetailsRepository{
    fun getRepositoryDetails(username: String,
                             repositoryName: String) : Observable<List<RepositoryDetail>>
}