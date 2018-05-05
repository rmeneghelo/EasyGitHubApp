package easy.com.br.easygithubapp.Application

import easy.com.br.easygithubapp.Model.Repository
import easy.com.br.easygithubapp.Repository.GitHubRepository
import easy.com.br.easygithubapp.Services.RetrofitService

class GetRepositoriesHandler{

    fun GetRepositories() : List<Repository>{
        val retrofitService = RetrofitService().Builder()

        val repository = GitHubRepository(retrofitService)

        return repository.GetRepositories()
    }
}