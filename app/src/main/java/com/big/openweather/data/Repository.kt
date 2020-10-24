package com.big.openweather.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.big.openweather.BuildConfig
import com.big.openweather.data.remote.NetworkService
import com.big.openweather.data.remote.response.weatherdetails.Json4Kotlin_Base
import retrofit2.Callback
import javax.inject.Inject


open class Repository @Inject constructor(private val networkService: NetworkService) {
    companion object {
        val TAG = "Repository"
    }
    val weatherLiveData: MutableLiveData<Json4Kotlin_Base> = MutableLiveData()

    fun getWeatherReport(query: String) {
        val data = networkService.getLiveData(query, BuildConfig.API_Key)

        data.enqueue(object : Callback<Json4Kotlin_Base> {
            override fun onResponse(
                call: retrofit2.Call<Json4Kotlin_Base>,
                response: retrofit2.Response<Json4Kotlin_Base>
            ) {

                if (!response.isSuccessful || response.code() != 200) {
                    weatherLiveData.value = null
                } else {
                    weatherLiveData.value = response.body()
                }
            }

            override fun onFailure(call: retrofit2.Call<Json4Kotlin_Base>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
                weatherLiveData.value = null
            }
        })
    }
}