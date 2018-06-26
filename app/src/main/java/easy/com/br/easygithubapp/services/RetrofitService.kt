package easy.com.br.easygithubapp.services
/*
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

interface IRetrofitService {
    fun Builder() : Retrofit
}

class RetrofitService @Inject constructor(private val gson: Gson, private val httpBuilder: OkHttpClient.Builder ) : IRetrofitService {

    override fun Builder(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        httpBuilder.addInterceptor(logging)

        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}*/