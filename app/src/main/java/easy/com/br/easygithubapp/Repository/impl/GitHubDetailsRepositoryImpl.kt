package easy.com.br.easygithubapp.Repository.impl

import easy.com.br.easygithubapp.Domain.Interfaces.IGitHubRepositoryDetailsService
import easy.com.br.easygithubapp.Domain.Model.RepositoryDetail
import easy.com.br.easygithubapp.Repository.GitHubDetailsRepository
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class GitHubDetailsRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : GitHubDetailsRepository {

    override fun GetRepositoryDetails(username: String,
                             repositoryName: String) : Observable<List<RepositoryDetail>> {
        val service = retrofit
                .create<IGitHubRepositoryDetailsService>(IGitHubRepositoryDetailsService::class.java)
        return service.details(username, repositoryName)
    }
}