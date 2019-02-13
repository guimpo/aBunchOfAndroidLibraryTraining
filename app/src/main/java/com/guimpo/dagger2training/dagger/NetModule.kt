package com.guimpo.dagger2training.dagger

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.guimpo.dagger2training.authentication.AuthenticationService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC

        val interceptorBody = HttpLoggingInterceptor()
        interceptorBody.level = HttpLoggingInterceptor.Level.BODY

        val interceptorHeader= HttpLoggingInterceptor()
        interceptorHeader.level = HttpLoggingInterceptor.Level.HEADERS

        return OkHttpClient.Builder()
//            .addInterceptor(interceptor)
            .addInterceptor(interceptorBody)
            .addInterceptor(interceptorHeader)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(gson: Gson, okHttpClient: OkHttpClient): AuthenticationService {
        return Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build().create(AuthenticationService::class.java)
    }
}