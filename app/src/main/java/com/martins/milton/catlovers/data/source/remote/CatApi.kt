package com.martins.milton.catlovers.data.source.remote

import com.martins.milton.catlovers.data.models.Result
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface CatApi {
    @Headers("Authorization: Client-ID 1ceddedc03a5d71")
    @GET("?q=cats&q_type=jpg")
    fun getCats(): Observable<Result>
}