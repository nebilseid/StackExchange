package com.example.stackexchange.data.api

import com.example.stackexchange.model.DataStackExchange
import io.reactivex.Single
import retrofit2.http.GET

interface StackExchangeApi {
    @GET("/2.2/users?order=asc&max=20&sort=name&site=stackoverflow")
    fun fetchUsers(): Single<DataStackExchange>
}