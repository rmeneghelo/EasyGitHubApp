package easy.com.br.easygithubapp.Application

import android.database.Observable
import android.util.Log
import easy.com.br.easygithubapp.Model.RepositoriesResult
import easy.com.br.easygithubapp.Model.Repository
import easy.com.br.easygithubapp.Repository.GitHubRepository
import easy.com.br.easygithubapp.Services.RetrofitService
import io.reactivex.Observable.just
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetRepositoriesHandler{

    fun GetRepositories() : List<Repository> {
        val retrofitService = RetrofitService().Builder()

        val repository = GitHubRepository(retrofitService)
        var list = listOf<Repository>()

        repository.GetRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            repositories ->
                            list = repositories.items
                            Log.d("Handler Xuxa 1", list.size.toString())

                        },
                        { error ->
                            Log.d("Xuxa erro handler", error.message)
                        }
                )

        Log.d("Handler Xuxa 2", list.size.toString())
        return list
    }
}