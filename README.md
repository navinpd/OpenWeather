# OpenWeather

OpenWeather is an Android project that allows you to quickly connect common UI elements to [OpenWeather](https://api.openweathermap.org/data/2.5/).
Currently in weather details we are showing weather icon, population,  & city name current. Details of every 3 hours for temperature, wind, status & visibility until next 5 day. After the project is synchronized, we're ready to start and get weather results.

## To Build Application:
You need latest Android Studio version to uild project.

## The project is using below libraries:
- Hilt Library for Dependency Injection
- Retrofit for network request and responses
- Okhttp3 for logging and ssl pinning
- Gson for Json to POJO
- Appcompat libraries for MVVM architecture

## Below dependencies are used:
```groovy

    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.2'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'

    // HILT
    implementation "com.google.dagger:hilt-android:2.28-alpha"
    kapt "com.google.dagger:hilt-android-compiler:2.28-alpha"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"

    // Networking
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.okhttp3:okhttp:4.2.1"
    implementation "com.squareup.okhttp3:logging-interceptor:4.2.1"

    // AppCompat
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.2'
    implementation "androidx.recyclerview:recyclerview:1.1.0"
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'

    implementation 'com.google.code.gson:gson:2.8.6'
```


## What could have been done better:
- UI could be improved had UI-Ux doc received
- Unit and UI tests cab be added
- Can use GoogleMaps for location selection to see live weather report
- Colorful images can be used for better look and feel
- Currently it's 1 screen application as per need it can be improved
