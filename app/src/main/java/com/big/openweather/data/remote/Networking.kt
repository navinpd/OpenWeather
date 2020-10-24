package com.big.openweather.data.remote


import com.big.openweather.BuildConfig
import okhttp3.Cache
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

object Networking {

    lateinit var API_VAL: String


    fun createNetworking(
        apiVal: String,
        baseUrl: String,
        cascheDir: File,
        cascheSize: Long
    ): NetworkService {
        API_VAL = apiVal
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .cache(Cache(cascheDir, cascheSize))
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                            else HttpLoggingInterceptor.Level.NONE
                        })
                        .certificatePinner(CertificatePinner.Builder()
                                .add("*openweathermap.org/*",
                                        "sha256/51ec81c0ace1dffd11ec631469cb3da27ea79fe15923c25f3a50a7f8642b2b79")
                        .build())
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(
                NetworkService::class.java
            )
    }

}