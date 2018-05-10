package easy.com.br.easygithubapp.Application

import android.util.Log
import easy.com.br.easygithubapp.Model.RepositoriesResult
import easy.com.br.easygithubapp.Repository.GitHubRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_easy_git_hub.*
import javax.inject.Inject

class GetRepositoriesHandler @Inject constructor(private val repository: GitHubRepository){

    private val repositoriesResultPublish = PublishSubject.create<RepositoriesResult>()
    val repositoriesResult: Observable<RepositoriesResult> get() = repositoriesResultPublish

    fun GetRepositories() {
        repository
                .GetRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            Log.d("Xuxa tentativa 1", result.items.size.toString())
                            repositoriesResultPublish.onNext(result)
                            repositoriesResultPublish.onComplete()
                        },
                        {
                            e -> Log.d("Xuxa tentativa erro", e.message)
                        }
                )
    }
}