package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.Application.GetRepositoriesHandler
import easy.com.br.easygithubapp.Repository.GitHubRepository
import javax.inject.Singleton

@Module
class GetRepositoriesHandlerModule {

    @Provides
    @Singleton
    fun provideGetRepsitoriesHandlerModule(gitHubRepository: GitHubRepository): GetRepositoriesHandler {
        return GetRepositoriesHandler(gitHubRepository)
    }
}