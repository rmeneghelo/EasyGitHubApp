package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.repository.GitHubDetailsRepository
import easy.com.br.easygithubapp.repository.GitHubRepository
import easy.com.br.easygithubapp.repository.impl.GitHubDetailsRepositoryImpl
import easy.com.br.easygithubapp.repository.impl.GithubRepositoryImpl

@Module
class GitHubRepositoryModule{

    @Provides
    fun provideGitHubRepository(impl: GithubRepositoryImpl): GitHubRepository = impl

    @Provides
    fun provideGitHubRepositoryDetails(impl: GitHubDetailsRepositoryImpl): GitHubDetailsRepository = impl
}