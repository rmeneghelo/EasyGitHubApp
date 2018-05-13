package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.Repository.GitHubDetailsRepository
import easy.com.br.easygithubapp.Repository.GitHubRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class GitHubRepositoryModule{

    @Provides
    @Singleton
    fun provideGitHubRepository(retrofit: Retrofit): GitHubRepository{
        return GitHubRepository(retrofit)
    }

    @Provides
    @Singleton
    fun provideGitHubRepositoryDetails(retrofit: Retrofit): GitHubDetailsRepository{
        return GitHubDetailsRepository(retrofit)
    }
}