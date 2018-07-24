package easy.com.br.easygithubapp.viewModel

import easy.com.br.easygithubapp.domain.model.*
import easy.com.br.easygithubapp.repository.GitHubRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class GetRepositoriesHandler @Inject constructor(private val repository: GitHubRepository){

    private val repositoriesResultPublish = PublishSubject.create<RepositoryDto>()
    val repositoriesResult: Observable<RepositoryDto> get() = repositoriesResultPublish

    fun getRepositories() {
        repository
                .getRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            var repositoriesList: List<UserRepository> = result.items.map { repoResult ->
                                UserRepository(repoResult.githubRepositoryName,
                                        repoResult.description,
                                        RepositoryOwner(repoResult.owner.authorName, repoResult.owner.authorPhoto),
                                        checkApacheLicense(repoResult.license),
                                        repoResult.starsNumber,
                                        repoResult.forksNumber,
                                        repoResult.openIssuesNumber)
                            }

                            repositoriesResultPublish.onNext(RepositoryDto(result.total_count, checkOpenIssuesMoreThanHundred(repositoriesList), repositoriesList))
                            repositoriesResultPublish.onComplete()
                        },
                        {
                            e ->
                            repositoriesResultPublish.onError(e)
                        }
                )
    }

    private fun checkOpenIssuesMoreThanHundred(repositoriesList: List<UserRepository>): Int {
        return repositoriesList.count { repository -> repository.openIssuesNumber > 100 }
    }

    private fun checkApacheLicense(license: License?): RepositoryLicense {
        var isApache = false

        license?.licenseKey?.let {
            if(it.contains("Apache", true)) {
                isApache = true
            }
        }

        return RepositoryLicense(isApache)
    }

}