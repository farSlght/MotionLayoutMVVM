package com.example.testapp.network

import com.example.testapp.repository.model.Plan
import io.reactivex.Single
import retrofit2.http.GET

interface OmniViewApi {
    @GET("/bins/b8yig")
    fun getPlan(): Single<Plan>
}