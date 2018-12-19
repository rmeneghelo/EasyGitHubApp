package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import easy.com.br.easygithubapp.view.EasyGitHubActivity
import easy.com.br.easygithubapp.view.EasyGitHubDetailsActivity


@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): EasyGitHubActivity

    @ContributesAndroidInjector
    internal abstract fun themeActivity(): EasyGitHubDetailsActivity

}
