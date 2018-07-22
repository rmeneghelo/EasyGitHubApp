package easy.com.br.easygithubapp

import com.google.gson.GsonBuilder
import easy.com.br.easygithubapp.TestHelper.Companion.API_RESPONSE
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import easy.com.br.easygithubapp.domain.model.Repository
import easy.com.br.easygithubapp.domain.model.RepositoryDto
import easy.com.br.easygithubapp.repository.GitHubRepository
import easy.com.br.easygithubapp.viewModel.GetRepositoriesHandler
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import java.util.concurrent.TimeoutException

@RunWith(MockitoJUnitRunner::class)
class GetRepositoriesHandlerTest {

    @Mock
    private lateinit var repository: GitHubRepository

    @InjectMocks
    private lateinit var getRepositoriesHandler: GetRepositoriesHandler


    private lateinit var apiResult: RepositoriesApiResult

    @Before
    fun setUp(){
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        apiResult = GsonBuilder().create().fromJson(API_RESPONSE, RepositoriesApiResult::class.java)
    }

    @Test
    fun `when repositories are requested, call getRepositories and return repositoriesDto`() {
        Mockito.`when`(repository.getRepositories()).thenReturn(Observable.just(apiResult))

        val testObserver = TestObserver<RepositoryDto>()

        getRepositoriesHandler
                .repositoriesResult
                .subscribe(testObserver)

        getRepositoriesHandler.getRepositories()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)

        val listResult = testObserver.values()[0]

        Assert.assertEquals(listResult.listRepositories.size, 2)
        Assert.assertEquals(listResult.listRepositories[0].owner.authorName, "iluwatar")
        Assert.assertEquals(listResult.listRepositories[1].owner.authorName, "ReactiveX")
    }

    @Test
    fun `when repositories are requested, call getRepositories and return no results return repositoriesDto`() {
        apiResult = RepositoriesApiResult(0, arrayListOf())
        Mockito.`when`(repository.getRepositories()).thenReturn(Observable.just(apiResult))

        val testObserver = TestObserver<RepositoryDto>()

        getRepositoriesHandler
                .repositoriesResult
                .subscribe(testObserver)

        getRepositoriesHandler.getRepositories()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)

        val listResult = testObserver.values()[0]

        Assert.assertEquals(listResult.listRepositories.size, 0)
    }

    @Test
    fun `when repositories are requested, call getRepositories and return exception`() {
        Mockito.`when`(repository.getRepositories()).thenReturn(Observable.error(Exception()))

        val testObserver = TestObserver<RepositoryDto>()

        getRepositoriesHandler
                .repositoriesResult
                .subscribe(testObserver)

        getRepositoriesHandler.getRepositories()

        testObserver.assertError(Exception::class.java)
    }

    @Test
    fun `when repositories are requested, call getRepositories and return timeout`() {
        Mockito.`when`(repository.getRepositories()).thenReturn(Observable.error(TimeoutException()))

        val testObserver = TestObserver<RepositoryDto>()

        getRepositoriesHandler
                .repositoriesResult
                .subscribe(testObserver)

        getRepositoriesHandler.getRepositories()

        testObserver.assertError(TimeoutException::class.java)
    }
}
