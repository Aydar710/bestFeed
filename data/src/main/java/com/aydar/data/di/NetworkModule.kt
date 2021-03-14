package com.aydar.data.di

import com.aydar.data.BuildConfig
import com.aydar.data.Preferences
import com.aydar.data.api.VkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = "https://api.vk.com/method/"

    @Singleton
    @Provides
    fun provideOkHttpClient(preferences: Preferences): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpBuilder
                .addInterceptor(loggingInterceptor)
                .build()
        }

        okHttpBuilder.interceptors().add(Interceptor { chain ->
            var request = chain.request()
            val url = request.url.newBuilder()
                .addQueryParameter(QUERY_PARAMETER_VERSION_NAME, QUERY_PARAMETER_VERSION_VALUE)
                .build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        })

        preferences.vkToken?.let { token ->
            okHttpBuilder.interceptors().add(Interceptor { chain ->
                var request = chain.request()
                val url = request.url.newBuilder()
                    .addQueryParameter(QUERY_PARAMETER_ACCESS_TOKEN, token)
                    .build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            })

        }

        return okHttpBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideVkApi(retrofit: Retrofit) = retrofit.create(VkApi::class.java)

}

const val QUERY_PARAMETER_VERSION_NAME = "v"
const val QUERY_PARAMETER_VERSION_VALUE = "5.126"
const val QUERY_PARAMETER_ACCESS_TOKEN = "access_token"