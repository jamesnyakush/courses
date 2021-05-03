buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.4")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.35.1")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean").configure {
    delete("build")
}

