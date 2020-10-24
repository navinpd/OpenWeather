package com.big.openweather.data.remote

import com.big.openweather.BuildConfig
import com.big.openweather.BuildConfig.CERT_PIN
import com.big.openweather.BuildConfig.URL_REGEX
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
                                        .add(URL_REGEX, CERT_PIN)
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