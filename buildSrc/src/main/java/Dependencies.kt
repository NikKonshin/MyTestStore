object Versions{

    //Kotlin
    const val core = "1.6.0"
    const val stdlib = "1.5.30"
    const val coroutinesCore = "1.5.1"
    const val coroutinesAndroid = "1.5.1"

    //Tools
    const val multidex = "2.0.1"

    //Design
    const val appcompat = "1.3.1"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.0"

    //Cicerone
    const val cicerone = "6.6"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val interceptor = "3.12.1"
    const val adapterCoroutines = "0.9.2"

    //Koin
    const val koinCore = "2.2.3"
    const val koinAndroid = "2.2.3"
    const val koinViewModel = "2.2.3"

    //Glide
    const val glide = "4.9.0"
    const val glideCompiler = "4.9.0"

    //Test
    const val jUnit = "4.12"
    const val ext = "1.1.3"
    const val espressoCore = "3.4.0"
}

object Kotlin{
    const val core = "androidx.core:core-ktx:${Versions.core}"
}

object Design{
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Tests{
    const val junit = "junit:junit:${Versions.jUnit}"
    const val ext = "androidx.test.ext:junit:${Versions.ext}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}