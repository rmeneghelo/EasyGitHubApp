package easy.com.br.easygithubapp.viewModel

import android.util.Log
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class GetRepositoryDetailsViewModel @Inject constructor(private val repository: GitHubDetailsRepository){

    private val repositoryDetailsResultPublish = PublishSubject.create<List<RepositoryDetail>>()
    val repositoryDetailsResult: Observable<List<RepositoryDetail>> get() = repositoryDetailsResultPublish

    fun getRepositoryDetails(username: String, repositoryName: String) {
        repository
                .getRepositoryDetails(username, repositoryName)
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