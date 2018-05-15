package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.Repository.GitHubDetailsRepository
import easy.com.br.easygithubapp.Repository.GitHubRepository
import easy.com.br.easygithubapp.Repository.impl.GitHubDetailsRepositoryImpl
import easy.com.br.easygithubapp.Repository.impl.GithubRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class GitHubRepositoryModule{

    @Provides
    fun provideGitHubRepository(impl: GithubRepositoryImpl): GitHubRepository = impl

    @Provides
    fun provideGitHubRepositoryDetails(impl: GitHubDetailsRepositoryImpl): GitHubDetailsRepository = impl
}