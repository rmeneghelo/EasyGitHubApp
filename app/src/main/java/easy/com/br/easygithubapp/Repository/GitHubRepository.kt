package easy.com.br.easygithubapp.Repository

import easy.com.br.easygithubapp.Domain.Interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.Model.RepositoryApiResult
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class GitHubRepository @Inject constructor(private val retrofit: Retrofit){

    fun GetRepositories() : Observable<RepositoryApiResult> {
        val service = retrofit
                .create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        return service.search()
    }
}
