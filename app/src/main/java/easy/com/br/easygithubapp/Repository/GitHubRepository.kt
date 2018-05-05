package easy.com.br.easygithubapp.Repository

import android.util.Log
import easy.com.br.easygithubapp.Domain.Interfaces.IGithubRepositoriesService
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

    fun GetRepositories() : Observable<List<Repository>> {
        val service = retrofitService.create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        return Observable.create {
            subscriber ->
            var listRepository = listOf<Repository>()
            service.search()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { result ->
                                run {
                                    Log.d("Xuxa 1", result.items.size.toString())
                                    listRepository = result.items
                                }
                            },
                            { error -> Log.d("Xuxa 2", error.message) }
                    )
            Log.d("Xuxa Repository", listRepository.size.toString())
            subscriber.onNext(listRepository)
            subscriber.onComplete()
        }
    }
}
