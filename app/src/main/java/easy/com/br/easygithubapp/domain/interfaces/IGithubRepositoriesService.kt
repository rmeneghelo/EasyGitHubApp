package easy.com.br.easygithubapp.domain.interfaces

import easy.com.br.easygithubapp.Model.RepositoriesApiResult
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by rafae on 03/11/2017.
 */
interface IGithubRepositoriesService {
    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun search(): Observable<RepositoriesApiResult>
}