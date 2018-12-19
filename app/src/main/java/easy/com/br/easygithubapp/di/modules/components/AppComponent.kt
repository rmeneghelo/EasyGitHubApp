package easy.com.br.easygithubapp.di.modules.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import easy.com.br.easygithubapp.App
import easy.com.br.easygithubapp.di.modules.*
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    RetrofitModule::class,
    GitHubViewModelModule::class,
    ActivityBindingModule::class,
    GitHubRepositoryModule::class
    ])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
