package easy.com.br.easygithubapp.di.modules.components

import dagger.Component
import easy.com.br.easygithubapp.viewModel.GetRepositoriesHandler
import easy.com.br.easygithubapp.viewModel.GetRepositoryDetailsHandler
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(GitHubRepositoryModule::class), (RetrofitModule::class)])
interface GetRepositoriesHandlerComponent{
    fun getRepositoriesHandler(): GetRepositoriesHandler
}

@Singleton
@Component(modules = [(GitHubRepositoryModule::class), (RetrofitModule::class)])
interface GetRepositoryDetailsHandlerComponent{
    fun getRepositoryDetailsHandler(): GetRepositoryDetailsHandler
}