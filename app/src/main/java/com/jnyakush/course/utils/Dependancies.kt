package com.jnyakush.course.utils

/**
 *
 */
object Versions {
    const val kotlinVersion = "1.3.72"
    const val hilt = "2.28.3-alpha"
    const val navigation = "2.3.0"
    const val coroutines = "1.3.0"
    const val hiltAndroidX = "1.0.0-alpha02"
    const val lifecycle = "2.1.0"
    const val retrofit = "2.7.1"
    const val okhttp = "4.3.1"
    const val material = "1.2.0"
    const val timber = "4.7.1"
    const val stetho = "1.5.1"
    const val room = "2.2.5"
    const val datastore = "1.0.0-alpha01"
    const val coreKtx = "1.3.1"
    const val appcompat = "1.2.0"
    const val constraintLayout = "1.1.3"
    const val legacySupportV4 = "1.0.0"
    const val junit = "4.12"
    const val testJunit = "1.1.1"
    const val espresso = "3.2.0"
}


/**
 *
 */
object BuildPlugins {
    const val application = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val androidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val navigation = "androidx.navigation.safeargs.kotlin"
    const val hilt = "dagger.hilt.android.plugin"
}


/**
 *
 */
object Libraries {

    // Kotlin standard Library
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"

    // Material Design
    const val material = "com.google.android.material:material:${Versions.material}"

    // Retrofit  & okhttp
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

    //Android Navigation Architecture
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Dagger Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltAndroidX}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltAndroidX}"

    // ViewModel and LiveData
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"


    // Room components
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val preferences = "androidx.datastore:datastore-preferences:${Versions.datastore}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"


    const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val legacySupportV4 = "androidx.legacy:legacy-support-v4:${Versions.legacySupportV4}"

}

/**
 *
 */
object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val testJunit = "androidx.test.ext:junit:${Versions.testJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

/**
 *
 */
object AndroidSdk {
    const val minSdkVersion = 21
    const val compileSdkVersion = 30
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0"
}



