package easy.com.br.easygithubapp.domain.interfaces

import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IGitHubRepositoryDetailsService {
    @GET("repos/{user}/{repositoryName}/pulls")
    fun details(@Path("user") user: String, @Path("repositoryName") repositoryName: String): Observable<List<RepositoryDetail>>
}