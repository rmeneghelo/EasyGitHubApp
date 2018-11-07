package easy.com.br.easygithubapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import easy.com.br.easygithubapp.TestHelper.Companion.API_RESPONSE_REPOSITORIES_DETAILS
import easy.com.br.easygithubapp.domain.model.*
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import easy.com.br.easygithubapp.viewmodel.GetRepositoryDetailsViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetRepositoryDetailsViewModelTest {
    @Mock
    private lateinit var repository: GitHubDetailsRepository

    @InjectMocks
    private lateinit var getRepositoryDetailsViewModel: GetRepositoryDetailsViewModel

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private lateinit var apiResult: MutableList<RepositoryDetail>

    @Before
    fun setUp(){
        apiResult = GsonBuilder().create().fromJson(API_RESPONSE_REPOSITORIES_DETAILS, object: TypeToken<MutableList<RepositoryDetail>>() {}.type)
    }

    @Test
    fun `when repositoriy details are requested, call getRepositories and return repository detail`() {

        val repoDetailResult = MutableLiveData<MutableList<RepositoryDetail>>()

        val observer: Observer<MutableList<RepositoryDetail>> = mock()

        whenever(repository.getRepositoryDetails(getUserRepositoryDetail()))
                .thenReturn(repoDetailResult)

        getRepositoryDetailsViewModel.repositoryDetailData.observeForever(observer)

        getRepositoryDetailsViewModel.getRepositoryDetails(getUserRepositoryDetail())

        repoDetailResult.value = apiResult

        getRepositoryDetailsViewModel.repositoryDetailData.value.let {
            assert(it?.size == 1)

            val result = it?.get(0)
            assert(result?.user?.username == "soshial")
        }
    }

    @Test
    fun `when repositoriy details are requested, should set loading to false`() {

        val repoDetailResult = MutableLiveData<MutableList<RepositoryDetail>>()

        val observer: Observer<MutableList<RepositoryDetail>> = mock()

        val observerLoading: Observer<Boolean> = mock()

        whenever(repository.getRepositoryDetails(getUserRepositoryDetail()))
                .thenReturn(repoDetailResult)

        getRepositoryDetailsViewModel.repositoryDetailData.observeForever(observer)
        getRepositoryDetailsViewModel.loadingData.observeForever(observerLoading)

        getRepositoryDetailsViewModel.getRepositoryDetails(getUserRepositoryDetail())

        repoDetailResult.value = apiResult

        assert(getRepositoryDetailsViewModel.loadingData.value == false)
    }

    private fun getUserRepositoryDetail() = UserRepositoryDetail("userName", "repositoryName")
}