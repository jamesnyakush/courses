package com.jnyakush.course.di

import androidx.room.Room
import com.jnyakush.course.data.db.AppDatabase
import com.jnyakush.course.data.repository.AuthRepository
import com.jnyakush.course.data.repository.CourseRepository
import com.jnyakush.course.data.repository.MyCoursesRepository
import com.jnyakush.course.data.retrofit.ApiClient
import com.jnyakush.course.ui.viewmodel.AuthViewModel
import com.jnyakush.course.ui.viewmodel.CourseViewModel
import com.jnyakush.course.ui.viewmodel.MyCoursesViewModel
import com.jnyakush.course.utils.AuthInterceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * This is networking  Module
 */
val networkingModule: Module = module(override = true) {

    single {

        Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {

        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(get()))
            .build()
    }
}

val viewModelsModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { CourseViewModel(get()) }
    viewModel { MyCoursesViewModel(get()) }
}

val repositoryModule = module {
    single { AuthRepository(get(),get()) }
    single { CourseRepository(get(),get(),get()) }
    single { MyCoursesRepository(get(),get(),get()) }
}


/**
 * This database singleton module class
 */
private val databaseModule: Module = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "course_db"
        ).build()
    }
}

/**
 * This is Data access object injection module
 */
private val daoModule: Module = module {
    single { get<AppDatabase>().courseDao() }
}



/**
 * This  is a list off the different modules
 */
val appModules: List<Module> = listOf(
    databaseModule,
    daoModule,
    repositoryModule,
    viewModelsModule,
    networkingModule
)