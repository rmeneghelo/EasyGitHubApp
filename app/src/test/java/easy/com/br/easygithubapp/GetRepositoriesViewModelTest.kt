package easy.com.br.easygithubapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.google.gson.GsonBuilder
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import easy.com.br.easygithubapp.TestHelper.Companion.API_RESPONSE
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import easy.com.br.easygithubapp.domain.model.UserRepository
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

@RunWith(MockitoJUnitRunner::class)
class GetRepositoriesViewModelTest {

    @Mock
    private lateinit var repository: GitHubRepository

    @InjectMocks
    private lateinit var getRepositoriesViewModel: GetRepositoriesViewModel

    @Mock
    private lateinit var call: Call<RepositoriesApiResult>

    @Mock lateinit var observer: Observer<List<UserRepository>>

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

        val repoResult = MutableLiveData<RepositoriesApiResult>()

        whenever(repository.getRepositories())
                .thenReturn(repoResult)

        getRepositoriesViewModel.repositoriesData.observeForever(observer)

        getRepositoriesViewModel.getRepositories()

        repoResult.value = apiResult

        getRepositoriesViewModel.repositoriesData.value.let {
            val result = it?.get(0)
            assert(result?.owner?.authorName.isNullOrBlank().not())
        }
    }
}
