package easy.com.br.easygithubapp.Domain.Interfaces

import easy.com.br.easygithubapp.Domain.Model.RepositoryDetailApiResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IGitHubRepositoryDetailsService {
    @GET("repos/{user}/{repositoryName}/pulls")
    fun details(@Path("user") user: String, @Path("repositoryName") repositoryName: String): Observable<RepositoryDetailApiResult>
}