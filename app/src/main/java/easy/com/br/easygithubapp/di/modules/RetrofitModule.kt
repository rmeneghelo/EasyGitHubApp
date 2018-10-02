package easy.com.br.easygithubapp.di.modules

import dagger.Module
import dagger.Provides
import easy.com.br.easygithubapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun provideBaseUrl(): String = BuildConfig.BASE_API_URL

    @Provides
    @Singleton
    internal fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()


    @Provides
    @Singleton
    internal fun provideRetrofitService(gson: GsonConverterFactory, okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(gson)
                    .client(okHttpClient)
                    .build()

}