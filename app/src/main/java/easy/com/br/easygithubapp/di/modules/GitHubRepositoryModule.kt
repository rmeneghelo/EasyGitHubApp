package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.Repository.GitHubRepository
import easy.com.br.easygithubapp.Services.RetrofitService
import javax.inject.Singleton

@Module
class GitHubRepositoryModule{

    @Provides
    @Singleton
    fun provideGitHubRepository(retrofitService: RetrofitService): GitHubRepository{
        return GitHubRepository(retrofitService)
    }
}