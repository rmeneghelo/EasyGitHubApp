package easy.com.br.easygithubapp.Repository.impl

import easy.com.br.easygithubapp.Domain.Interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.Model.RepositoriesApiResult
import easy.com.br.easygithubapp.Repository.GitHubRepository
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : GitHubRepository {

    override fun GetRepositories() : Observable<RepositoriesApiResult> {
        val service = retrofit
                .create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        return service.search()
    }
}