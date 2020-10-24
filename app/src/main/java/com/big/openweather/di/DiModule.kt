package com.big.openweather.di

import android.content.Context
import android.content.SharedPreferences
import com.big.openweather.BuildConfig
import com.big.openweather.data.Repository
import com.big.openweather.data.remote.NetworkService
import com.big.openweather.data.remote.Networking
import com.big.openweather.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object DiModule {

    @Provides
    fun provideNetworking(@ApplicationContext appContext: Context): NetworkService {
        return Networking.createNetworking(
            BuildConfig.API_Key,
            BuildConfig.BASE_URL,
            appContext.cacheDir,
            10 * 1024 * 1024
        )
    }

    @Provides
    fun provideSharedPreference(@ApplicationContext appContext: Context): SharedPreferences =
        appContext.getSharedPreferences("Local-Shared-Pref", 0)

    @Provides
    fun provideSearchViewModel(repository: Repository): MainViewModel =
        MainViewModel(repository)
}