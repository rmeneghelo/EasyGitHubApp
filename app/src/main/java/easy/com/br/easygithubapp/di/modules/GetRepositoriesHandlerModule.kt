package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.viewModel.GetRepositoriesHandler
import easy.com.br.easygithubapp.repository.GitHubRepository

@Module
class GetRepositoriesHandlerModule {

    @Provides
    fun provideGetRepositoriesHandlerModule(gitHubRepository: GitHubRepository): GetRepositoriesHandler {
        return GetRepositoriesHandler(gitHubRepository)
    }
}