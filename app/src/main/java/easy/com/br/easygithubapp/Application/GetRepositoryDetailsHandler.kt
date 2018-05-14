package easy.com.br.easygithubapp.Application

import android.util.Log
import easy.com.br.easygithubapp.Domain.Model.RepositoryDetail
import easy.com.br.easygithubapp.Domain.Model.RepositoryDetailApiResult
import easy.com.br.easygithubapp.Repository.GitHubDetailsRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class GetRepositoryDetailsHandler @Inject constructor(private val repository: GitHubDetailsRepository){

    private val repositoryDetailsResultPublish = PublishSubject.create<List<RepositoryDetail>>()
    val repositoryDetailsResult: Observable<List<RepositoryDetail>> get() = repositoryDetailsResultPublish

    fun GetRepositoryDetails(username: String, repositoryName: String) {
        repository
                .GetRepositoryDetails(username, repositoryName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                    {
                        result ->
                        Log.d("Handler Details", result.size.toString())
                        repositoryDetailsResultPublish.onNext(result)
                        repositoryDetailsResultPublish.onComplete()
                    },
                    {
                        e -> Log.d("Erro Details Handler", e.message)
                    }
                )
    }
}