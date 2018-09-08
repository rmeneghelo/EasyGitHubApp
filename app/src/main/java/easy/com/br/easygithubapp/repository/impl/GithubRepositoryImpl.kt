package easy.com.br.easygithubapp.repository.impl

import easy.com.br.easygithubapp.domain.interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import easy.com.br.easygithubapp.repository.GitHubRepository
import retrofit2.Callback
import retrofit2.Retrofit
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val retrofit: Retrofit) : GitHubRepository {
    override fun getRepositories(callback: Callback<RepositoriesApiResult>) {
        val service = retrofit
                .create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        service.searchNew().enqueue(callback)
    }
}