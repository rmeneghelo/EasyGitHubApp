package easy.com.br.easygithubapp.Application

import android.util.Log
import easy.com.br.easygithubapp.Model.Repository
import easy.com.br.easygithubapp.Repository.GitHubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetRepositoriesHandler @Inject constructor(private val repository: GitHubRepository){

    fun GetRepositories() : List<Repository> {
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