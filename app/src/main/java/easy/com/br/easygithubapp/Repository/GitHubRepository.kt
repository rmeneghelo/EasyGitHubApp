package easy.com.br.easygithubapp.Repository

import easy.com.br.easygithubapp.Domain.Interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.Model.RepositoriesResult
import easy.com.br.easygithubapp.Services.RetrofitService
import io.reactivex.Observable
import javax.inject.Inject

class GitHubRepository @Inject constructor(private val retrofitService: RetrofitService){

    fun GetRepositories() : Observable<RepositoriesResult> {
        val service = retrofitService
                .Builder()
                .create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        return service.search()
    }
}
