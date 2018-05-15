package easy.com.br.easygithubapp

import com.google.gson.GsonBuilder
import easy.com.br.easygithubapp.Application.GetRepositoriesHandler
import easy.com.br.easygithubapp.Domain.Model.RepositoryDto
import easy.com.br.easygithubapp.Model.RepositoriesApiResult
import easy.com.br.easygithubapp.Repository.GitHubRepository
import easy.com.br.easygithubapp.TestHelper.Companion.API_RESPONSE
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

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
    fun addition_isCorrect() {
        Mockito.`when`(repository.GetRepositories()).thenReturn(Observable.just(apiResult))

        getRepositoriesHandler.GetRepositories()

        val testObserver = TestObserver<RepositoryDto>()

        getRepositoriesHandler
                .repositoriesResult
                .subscribe(testObserver)

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val listResult = testObserver.values()[0]

        Assert.assertEquals(listResult.listRepositories.size, 2)
    }
}
