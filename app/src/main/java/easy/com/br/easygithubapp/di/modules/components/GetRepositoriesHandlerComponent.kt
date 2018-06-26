package easy.com.br.easygithubapp.di.modules.components

import dagger.Component
import easy.com.br.easygithubapp.application.GetRepositoriesHandler
import easy.com.br.easygithubapp.application.GetRepositoryDetailsHandler
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(GitHubRepositoryModule::class, RetrofitModule::class))
interface GetRepositoriesHandlerComponent{
    fun getRepositoriesHandler(): GetRepositoriesHandler
}

@Singleton
@Component(modules = arrayOf(GitHubRepositoryModule::class, RetrofitModule::class))
interface GetRepositoryDetailsHandlerComponent{
    fun getRepositoryDetailsHandler(): GetRepositoryDetailsHandler
}