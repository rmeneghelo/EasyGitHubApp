package easy.com.br.easygithubapp.Application

import easy.com.br.easygithubapp.Model.RepositoriesResult
import easy.com.br.easygithubapp.Repository.GitHubRepository
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class GetRepositoriesHandler @Inject constructor(private val repository: GitHubRepository){

    var repositoriesResultPublish: Observable<RepositoriesResult> = PublishSubject.create<RepositoriesResult>()

    fun GetRepositories() {
        repositoriesResultPublish = repository.GetRepositories()
    }
}