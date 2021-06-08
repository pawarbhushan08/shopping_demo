package com.example.data.di

import com.example.data.BuildConfig
import com.example.data.common.utils.MockInterceptor
import com.example.data.networking.ProductsApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
const val API_KEY = "0a9c8b845f566dd97bf703fcc664778b"

val networkingModule = module {
    single { GsonConverterFactory.create() as Converter.Factory }
    //single { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) as Interceptor }
    single<Interceptor> { MockInterceptor() }
    single {
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) addInterceptor(get())
                .callTimeout(10, TimeUnit.SECONDS)
        }.build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(get())
            .build()
    }
    single { get<Retrofit>().create(ProductsApi::class.java) }
}