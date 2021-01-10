package com.example.stackexchange.data.repository

import com.example.stackexchange.data.api.StackExchangeApi
import com.example.stackexchange.model.DataStackExchange
import io.reactivex.Single

interface StackExchangeRepository {
    fun fetchUsers(): Single<DataStackExchange>
}

class UsersRepository(private val stackExchangeApi: StackExchangeApi) : StackExchangeRepository {
    override fun fetchUsers(): Single<DataStackExchange> = stackExchangeApi.fetchUsers()
}