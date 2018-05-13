package easy.com.br.easygithubapp.Application

import android.util.Log
import easy.com.br.easygithubapp.Domain.Model.License
import easy.com.br.easygithubapp.Domain.Model.Owner
import easy.com.br.easygithubapp.Domain.Model.Repository
import easy.com.br.easygithubapp.Domain.Model.RepositoryDto
import easy.com.br.easygithubapp.Repository.GitHubRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class GetRepositoriesHandler @Inject constructor(private val repository: GitHubRepository){

    private val repositoriesResultPublish = PublishSubject.create<RepositoryDto>()
    val repositoriesResult: Observable<RepositoryDto> get() = repositoriesResultPublish

    fun GetRepositories() {
        repository
                .GetRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            var repositoriesList: List<Repository> = result.items.map { repoResult ->
                                Repository(repoResult.githubRepositoryName,
                                        repoResult.description,
                                        Owner(repoResult.owner.authorName, repoResult.owner.authorPhoto),
                                        CheckApacheLicense(repoResult.license?.licenseKey),
                                        repoResult.starsNumber,
                                        repoResult.forksNumber,
                                        repoResult.openIssuesNumber)
                            }
                            Log.d("Xuxa tentativa 1", result.items.size.toString())


                            repositoriesResultPublish.onNext(RepositoryDto(result.total_count, CheckOpenIssuesMoreThanHundred(repositoriesList), repositoriesList))
                            repositoriesResultPublish.onComplete()
                        },
                        {
                            e ->
                            Log.d("Xuxa tentativa erro", e.message)
                            repositoriesResultPublish.onError(e)
                        }
                )
    }

    private fun CheckOpenIssuesMoreThanHundred(repositoriesList: List<Repository>): Int {
        return repositoriesList.count { repository -> repository.openIssuesNumber > 100 }
    }

    private fun CheckApacheLicense(key: String): License {
        var isApache = false
        if(!key.isNullOrEmpty() && key.contains("Apache", true)) {
            isApache = true
        }

        return License(isApache)
    }

}