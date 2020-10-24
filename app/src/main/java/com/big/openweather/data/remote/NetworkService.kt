package com.big.openweather.data.remote

import com.big.openweather.BuildConfig
import com.big.openweather.data.remote.Endpoints.END_POINT
import com.big.openweather.data.remote.response.weatherdetails.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    // https://api.openweathermap.org/data/2.5/forecast?q=London&APPID=57e9d39f498035faf90d3e8c95adad24
    @GET(BuildConfig.BASE_URL + END_POINT)
    fun getLiveData(
            @Query(Endpoints.KEY_QUERY) queryText: String,
            @Query(Endpoints.KEY_API_KEY) apiKey: String = Networking.API_VAL
            //TODO add more API fields
    ): Call<Json4Kotlin_Base>
    /*
    {
  "cod": "200",
  "message": 0,
  "cnt": 40,
  "list": [
    {
      "dt": 1603465200,
      "main": {
        "temp": 288.83,
        "feels_like": 284.82,
        "temp_min": 288.6,
        "temp_max": 288.83,
        "pressure": 1007,
        "sea_level": 1007,
        "grnd_level": 1005,
        "humidity": 66,
        "temp_kf": 0.23
      },
      "weather": [
        {
          "id": 802,
          "main": "Clouds",
          "description": "scattered clouds",
          "icon": "03d"
        }
      ],
      "clouds": {
        "all": 47
      },
      "wind": {
        "speed": 5.55,
        "deg": 240
      },
      "visibility": 10000,
      "pop": 0.02,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2020-10-23 15:00:00"
    },
    {
      "dt": 1603886400,
      "main": {
        "temp": 286.42,
        "feels_like": 279.03,
        "temp_min": 286.42,
        "temp_max": 286.42,
        "pressure": 997,
        "sea_level": 997,
        "grnd_level": 994,
        "humidity": 54,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "clouds": {
        "all": 92
      },
      "wind": {
        "speed": 8.72,
        "deg": 232
      },
      "visibility": 10000,
      "pop": 0.49,
      "rain": {
        "3h": 0.51
      },
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2020-10-28 12:00:00"
    }
  ],
  "city": {
    "id": 2643743,
    "name": "London",
    "coord": {
      "lat": 51.5085,
      "lon": -0.1257
    },
    "country": "GB",
    "population": 1000000,
    "timezone": 3600,
    "sunrise": 1603435118,
    "sunset": 1603471838
  }
}*/

}