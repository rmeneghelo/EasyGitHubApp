package easy.com.br.easygithubapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.GsonBuilder
import easy.com.br.easygithubapp.TestHelper.Companion.API_RESPONSE
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import easy.com.br.easygithubapp.repository.GitHubRepository
import easy.com.br.easygithubapp.viewmodel.GetRepositoriesViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Response


@RunWith(MockitoJUnitRunner::class)
class GetRepositoriesViewModelTest {

    @Mock
    private lateinit var repository: GitHubRepository

    @InjectMocks
    private lateinit var getRepositoriesViewModel: GetRepositoriesViewModel

    @Mock
    private lateinit var call: Call<RepositoriesApiResult>

    private lateinit var apiResult: RepositoriesApiResult

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        apiResult = GsonBuilder().create().fromJson(API_RESPONSE, RepositoriesApiResult::class.java)
    }

    @Test
    fun `when repositories are requested, call getRepositories and return repositoriesDto`() {
        getRepositoriesViewModel.onResponse(call, Response.success(apiResult))
    }

//    @Test
//    fun `when repositories are requested, call getRepositories and return no results return repositoriesDto`() {
//        apiResult = RepositoriesApiResult(0, arrayListOf())
//        Mockito.`when`(repository.getRepositories()).thenReturn(Observable.just(apiResult))
//
//        val testObserver = TestObserver<RepositoryDto>()
//
//        getRepositoriesViewModel
//                .repositoriesResult
//                .subscribe(testObserver)
//
//        getRepositoriesViewModel.getRepositories()
//
//        testObserver.assertComplete()
//        testObserver.assertNoErrors()
//        testObserver.assertValueCount(1)
//
//        val listResult = testObserver.values()[0]
//
//        Assert.assertEquals(listResult.listRepositories.size, 0)
//    }
//
//    @Test
//    fun `when repositories are requested, call getRepositories and return exception`() {
//        Mockito.`when`(repository.getRepositories()).thenReturn(Observable.error(Exception()))
//
//        val testObserver = TestObserver<RepositoryDto>()
//
//        getRepositoriesViewModel
//                .repositoriesResult
//                .subscribe(testObserver)
//
//        getRepositoriesViewModel.getRepositories()
//
//        testObserver.assertError(Exception::class.java)
//    }
//
//    @Test
//    fun `when repositories are requested, call getRepositories and return timeout`() {
//        Mockito.`when`(repository.getRepositories()).thenReturn(Observable.error(TimeoutException()))
//
//        val testObserver = TestObserver<RepositoryDto>()
//
//        getRepositoriesViewModel
//                .repositoriesResult
//                .subscribe(testObserver)
//
//        getRepositoriesViewModel.getRepositories()
//
//        testObserver.assertError(TimeoutException::class.java)
//    }
}
