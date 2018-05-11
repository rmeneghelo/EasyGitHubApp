package easy.com.br.easygithubapp.Repository

import easy.com.br.easygithubapp.Domain.Interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.Model.RepositoriesResult
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class GitHubRepository @Inject constructor(private val retrofit: Retrofit){

    fun GetRepositories() : Observable<RepositoriesResult> {
        val service = retrofit
                .create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        return service.search()
    }
}
