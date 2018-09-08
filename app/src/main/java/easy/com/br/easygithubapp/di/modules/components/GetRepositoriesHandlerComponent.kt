package easy.com.br.easygithubapp.di.modules.components

import dagger.Component
import easy.com.br.easygithubapp.viewmodel.GetRepositoriesViewModel
import easy.com.br.easygithubapp.viewmodel.GetRepositoryDetailsViewModel
import easy.com.br.easygithubapp.di.modules.GitHubRepositoryModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(GitHubRepositoryModule::class), (RetrofitModule::class)])
interface GetRepositoriesHandlerComponent{
    fun getRepositoriesViewModel(): GetRepositoriesViewModel
}

@Singleton
@Component(modules = [(GitHubRepositoryModule::class), (RetrofitModule::class)])
interface GetRepositoryDetailsHandlerComponent{
    fun getRepositoryDetailsViewModel(): GetRepositoryDetailsViewModel
}