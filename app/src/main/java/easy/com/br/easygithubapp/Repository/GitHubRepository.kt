package easy.com.br.easygithubapp.Repository

import android.util.Log
import easy.com.br.easygithubapp.Domain.Interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.Model.RepositoriesResult
import easy.com.br.easygithubapp.Model.Repository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class GitHubRepository{

    var retrofitService: Retrofit


    constructor(retrofit : Retrofit){
        retrofitService = retrofit
    }

    fun GetRepositories() : Observable<RepositoriesResult> {
        val service = retrofitService.create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        return service.search()
    }
}
