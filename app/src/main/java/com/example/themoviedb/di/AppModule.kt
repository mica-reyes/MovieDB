package com.example.themoviedb.di

import com.example.themoviedb.BuildConfig
import com.example.themoviedb.data.remote.ApiKeyInterceptor
import com.example.themoviedb.data.MovieRepository
import com.example.themoviedb.data.remote.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApiService(): MovieService {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(MovieService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(apiService: MovieService): MovieRepository{
        return MovieRepository(apiService)
    }

}