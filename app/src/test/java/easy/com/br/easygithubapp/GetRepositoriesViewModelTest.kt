package easy.com.br.easygithubapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.gson.GsonBuilder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import easy.com.br.easygithubapp.TestHelper.Companion.API_RESPONSE_REPOSITORIES
import easy.com.br.easygithubapp.domain.model.*
import easy.com.br.easygithubapp.repository.GitHubRepository
import easy.com.br.easygithubapp.viewmodel.GetRepositoriesViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetRepositoriesViewModelTest {

    @Mock
    private lateinit var repository: GitHubRepository

    @InjectMocks
    private lateinit var getRepositoriesViewModel: GetRepositoriesViewModel

    private lateinit var apiResult: RepositoriesApiResult

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        apiResult = GsonBuilder().create().fromJson(API_RESPONSE_REPOSITORIES, RepositoriesApiResult::class.java)
    }

    @Test
    fun `when repositories are requested, call getRepositories and return repositoriesDto`() {

        val repoResult = MutableLiveData<Result<RepositoriesApiResult, String>>()

        val observer: Observer<List<UserRepository>> = mock()

        whenever(repository.getRepositories())
                .thenReturn(repoResult)

        getRepositoriesViewModel.repositoriesData.observeForever(observer)

        getRepositoriesViewModel.getRepositories()

        repoResult.value = ValueResult(apiResult)

        getRepositoriesViewModel.repositoriesData.value.let {
            assert(it?.size == 2)

            val result = it?.get(0)
            assert(result?.owner?.authorName.isNullOrBlank().not())
        }
    }

    @Test
    fun `when repositories are requested, call getRepositories and return header`() {

        val repoResult = MutableLiveData<Result<RepositoriesApiResult, String>>()

        val observer: Observer<HeaderDto> = mock()

        whenever(repository.getRepositories())
                .thenReturn(repoResult)

        getRepositoriesViewModel.headerData.observeForever(observer)

        getRepositoriesViewModel.getRepositories()

        repoResult.value = ValueResult(apiResult)

        getRepositoriesViewModel.headerData.value.let {
            assert(it?.totalRepositories == 2)
            assert(it?.totalMoreThanHundredOpenIssues == 1)
        }
    }

    @Test
    fun `when repositories are requested, should set loading to false`() {

        val repoResult = MutableLiveData<Result<RepositoriesApiResult, String>>()

        val observer: Observer<HeaderDto> = mock()

        val observerLoading: Observer<Boolean> = mock()

        whenever(repository.getRepositories())
                .thenReturn(repoResult)

        getRepositoriesViewModel.headerData.observeForever(observer)
        getRepositoriesViewModel.loadingData.observeForever(observerLoading)

        getRepositoriesViewModel.getRepositories()

        repoResult.value = ValueResult(apiResult)

        assert(getRepositoriesViewModel.loadingData.value == false)
    }

    @Test
    fun `when repositories are requested and fails, should set error data to true`() {

        val repoResult = MutableLiveData<Result<RepositoriesApiResult, String>>()

        val observer: Observer<List<UserRepository>> = mock()

        val observerLoading: Observer<Boolean> = mock()

        whenever(repository.getRepositories())
                .thenReturn(repoResult)

        getRepositoriesViewModel.repositoriesData.observeForever(observer)
        getRepositoriesViewModel.errorData.observeForever(observerLoading)

        getRepositoriesViewModel.getRepositories()

        repoResult.value = ErrorResult("error")

        assert(getRepositoriesViewModel.errorData.value == true)
    }

    @Test
    fun `when repositories are requested and fails, should set loading to false`() {

        val repoResult = MutableLiveData<Result<RepositoriesApiResult, String>>()

        val observer: Observer<List<UserRepository>> = mock()

        val observerLoading: Observer<Boolean> = mock()

        whenever(repository.getRepositories())
                .thenReturn(repoResult)

        getRepositoriesViewModel.repositoriesData.observeForever(observer)
        getRepositoriesViewModel.errorData.observeForever(observerLoading)

        getRepositoriesViewModel.getRepositories()

        repoResult.value = ErrorResult("error")

        assert(getRepositoriesViewModel.loadingData.value == false)
    }
}
