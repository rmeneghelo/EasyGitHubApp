package easy.com.br.easygithubapp.di.modules.Components

import dagger.Component
import easy.com.br.easygithubapp.Application.GetRepositoriesHandler
import easy.com.br.easygithubapp.di.modules.GetRepositoriesHandlerModule
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(GetRepositoriesHandlerModule::class, RetrofitModule::class))
interface GetRepositoriesHandlerComponent{
    fun getRepositoriesHandler(): GetRepositoriesHandler
}