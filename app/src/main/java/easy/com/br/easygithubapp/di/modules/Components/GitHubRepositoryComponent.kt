package easy.com.br.easygithubapp.di.modules.Components

import dagger.Component
import easy.com.br.easygithubapp.di.modules.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RetrofitModule::class))
interface GitHubRepositoryComponent{
    fun getGitHubRepositoryComponent(): GitHubRepositoryComponent
}