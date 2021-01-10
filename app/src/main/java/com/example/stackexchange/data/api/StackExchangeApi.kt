package com.example.stackexchange.data.api

import com.example.stackexchange.model.DataStackExchange
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface StackExchangeApi {
    @GET("/2.2/users?order=asc&sort=name&site=stackoverflow")
    fun fetchUsers(): Single<DataStackExchange>

    @GET("/2.2/users?order=asc&sort=name&site=stackoverflow")
    fun searchUsers(@Query("inname") name: String): Single<DataStackExchange>
}