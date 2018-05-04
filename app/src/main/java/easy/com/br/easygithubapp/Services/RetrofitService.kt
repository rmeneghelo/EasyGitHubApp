package easy.com.br.easygithubapp.Services

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface IRetrofitService {
    fun Builder() : Retrofit
}

class RetrofitService : IRetrofitService {

    override fun Builder(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(logging)

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}