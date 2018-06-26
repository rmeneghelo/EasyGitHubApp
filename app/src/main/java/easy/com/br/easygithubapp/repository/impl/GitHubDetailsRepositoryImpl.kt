package easy.com.br.easygithubapp.repository.impl

import easy.com.br.easygithubapp.domain.interfaces.IGitHubRepositoryDetailsService
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class GitHubDetailsRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : GitHubDetailsRepository {

    override fun getRepositoryDetails(username: String,
                                      repositoryName: String) : Observable<List<RepositoryDetail>> {
        val service = retrofit
                .create<IGitHubRepositoryDetailsService>(IGitHubRepositoryDetailsService::class.java)
        return service.details(username, repositoryName)
    }
}