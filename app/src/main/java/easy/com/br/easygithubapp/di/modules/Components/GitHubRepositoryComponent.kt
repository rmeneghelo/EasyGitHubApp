package easy.com.br.easygithubapp.di.modules.Components

import dagger.Component
import easy.com.br.easygithubapp.Repository.GitHubDetailsRepository
import easy.com.br.easygithubapp.Repository.GitHubRepository
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RetrofitModule::class, GitHubRepositoryModule::class))
interface GitHubRepositoryComponent{
    fun getGitHubRepositoryComponent(): GitHubRepository
}

@Singleton
@Component(modules = arrayOf(RetrofitModule::class, GitHubRepositoryModule::class))
interface GitHubRepositoryDetailComponent{
    fun getGitHubRepositoryDetailComponent(): GitHubDetailsRepository
}