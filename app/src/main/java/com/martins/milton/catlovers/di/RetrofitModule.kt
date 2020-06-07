package com.martins.milton.catlovers.di

import com.martins.milton.catlovers.data.source.remote.CatApi
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    private val baseUrl: String = "https://api.imgur.com/3/gallery/search/"

    @Singleton
    @Provides
    fun catApi(retrofit: Retrofit): CatApi {
        return retrofit.create(CatApi::class.java)
    }

    @Singleton
    @Provides
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}
