package easy.com.br.easygithubapp.Repository

import android.util.Log
import easy.com.br.easygithubapp.Domain.Interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.Model.RepositoriesResult
import easy.com.br.easygithubapp.Model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class GitHubRepository{

    var retrofitService: Retrofit
    var listRepository = listOf<Repository>()

    constructor(retrofit : Retrofit){
        retrofitService = retrofit
    }

    fun GetRepositories() : List<Repository>{
        val service = retrofitService.create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        val result = service.search()

        result.enqueue(object : Callback<RepositoriesResult> {
            override fun onFailure(call: Call<RepositoriesResult?>, t: Throwable?) {
                Log.d("Xuxa", t.toString())
            }

            override fun onResponse(call: Call<RepositoriesResult>, response: Response<RepositoriesResult>) {
                listRepository = response.body()!!.items

                Log.d("Xuxa", listRepository.size.toString())
            }
        })

        Log.d("Xuxa 2", listRepository.size.toString())

        return listRepository
    }
}
