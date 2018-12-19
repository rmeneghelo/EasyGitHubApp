package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import easy.com.br.easygithubapp.viewmodel.GetRepositoriesViewModel
import easy.com.br.easygithubapp.repository.GitHubRepository
import easy.com.br.easygithubapp.viewmodel.GetRepositoryDetailsViewModel

@Module
class GetRepositoriesHandlerModule {
    @Provides
    fun provideGetRepositoriesViewModel(gitHubRepository: GitHubRepository): GetRepositoriesViewModel {
        return GetRepositoriesViewModel(gitHubRepository)
    }

    @Provides
    fun provideGetRepositoryDetailsViewModel(gitHubDetailsRepository: GitHubDetailsRepository): GetRepositoryDetailsViewModel {
        return GetRepositoryDetailsViewModel(gitHubDetailsRepository)
    }
}