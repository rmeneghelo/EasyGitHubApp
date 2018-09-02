package easy.com.br.easygithubapp.di.modules.components

import dagger.Component
import easy.com.br.easygithubapp.viewModel.GetRepositoriesViewModel
import easy.com.br.easygithubapp.viewModel.GetRepositoryDetailsViewModel
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(GitHubRepositoryModule::class), (RetrofitModule::class)])
interface GetRepositoriesHandlerComponent{
    fun getRepositoriesHandler(): GetRepositoriesViewModel
}

@Singleton
@Component(modules = [(GitHubRepositoryModule::class), (RetrofitModule::class)])
interface GetRepositoryDetailsHandlerComponent{
    fun getRepositoryDetailsHandler(): GetRepositoryDetailsViewModel
}