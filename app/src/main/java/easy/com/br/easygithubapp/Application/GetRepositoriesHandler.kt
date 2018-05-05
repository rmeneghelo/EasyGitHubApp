package easy.com.br.easygithubapp.Application

import android.util.Log
import easy.com.br.easygithubapp.Model.Repository
import easy.com.br.easygithubapp.Repository.GitHubRepository
import easy.com.br.easygithubapp.Services.RetrofitService

class GetRepositoriesHandler{

    fun GetRepositories() : List<Repository> {
        val retrofitService = RetrofitService().Builder()

        val repository = GitHubRepository(retrofitService)
        var list = listOf<Repository>()

        repository.GetRepositories().subscribe(
                {
                    result ->
                    Log.d("Handler Xuxa", result.size.toString())
                    list = result
                },
                { e ->
                    Log.d("Erro na view", e.toString())
                }
        )
        Log.d("Handler Xuxa 2", list.size.toString())
        return list
    }
}