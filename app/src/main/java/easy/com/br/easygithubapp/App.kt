package easy.com.br.easygithubapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import easy.com.br.easygithubapp.di.modules.components.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }
}
