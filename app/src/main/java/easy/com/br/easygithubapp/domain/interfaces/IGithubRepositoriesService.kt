package easy.com.br.easygithubapp.domain.interfaces

import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface IGithubRepositoriesService {
    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun search(): Observable<RepositoriesApiResult>

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun searchNew(): Call<RepositoriesApiResult>
}