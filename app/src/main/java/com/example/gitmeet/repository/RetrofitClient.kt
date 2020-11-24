package com.example.gitmeet.repository

import okhttp3.Callback
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        private lateinit var retrofit: Retrofit
        fun getRetrofitInstance(): Retrofit {
            if (!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .client(
                        OkHttpClient.Builder()
                            .addInterceptor {
                                val req = it.request()
                                    .newBuilder()
                                    .addHeader("Accept", "application/vnd.github.v3+json")
                                    .build()
                                it.proceed(req)
                            }
                            .addInterceptor(HttpLoggingInterceptor())
                            .build()
                    )
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit;
        }

        fun <T> createService(servClass: Class<T>): T {
            return getRetrofitInstance().create(servClass)
        }
    }

}