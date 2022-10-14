package com.example.themoviedb.data

import com.example.themoviedb.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val instance: Retrofit

        get() {
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
            return Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
   }