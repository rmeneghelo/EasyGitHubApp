package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.application.GetRepositoriesHandler
import easy.com.br.easygithubapp.repository.GitHubRepository

@Module
class GetRepositoriesHandlerModule {

    @Provides
    fun provideGetRepsitoriesHandlerModule(gitHubRepository: GitHubRepository): GetRepositoriesHandler {
        return GetRepositoriesHandler(gitHubRepository)
    }
}