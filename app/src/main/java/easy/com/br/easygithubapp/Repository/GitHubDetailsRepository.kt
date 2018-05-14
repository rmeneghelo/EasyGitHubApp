package easy.com.br.easygithubapp.Repository

import easy.com.br.easygithubapp.Domain.Interfaces.IGitHubRepositoryDetailsService
import easy.com.br.easygithubapp.Domain.Model.RepositoryDetail
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class GitHubDetailsRepository @Inject constructor(private val retrofit: Retrofit){

    fun GetRepositoryDetails(username: String,
                             repositoryName: String) : Observable<List<RepositoryDetail>> {
        val service = retrofit
                .create<IGitHubRepositoryDetailsService>(IGitHubRepositoryDetailsService::class.java)
        return service.details(username, repositoryName)
    }
}