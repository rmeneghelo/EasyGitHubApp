package easy.com.br.easygithubapp.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.Services.RetrofitService
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class RetrofitModule{
    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @Provides
    @Singleton
    internal fun provideRetrofitService(gson: Gson, okHttpClient: OkHttpClient.Builder): RetrofitService {
        return RetrofitService(gson, okHttpClient)
    }
}