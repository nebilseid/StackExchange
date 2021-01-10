package com.example.stackexchange.model

data class DataStackExchange(
    val hasMore: Boolean,
    val items: List<Item>,
    val quotaMax: Int,
    val quotaRemaining: Int
)

data class Item(
    val acceptRate: Int,
    val accountId: Int,
    val badgeCounts: BadgeCounts,
    val creationDate: Int,
    val displayName: String,
    val isEmployee: Boolean,
    val lastAccessDate: Int,
    val lastModifiedDate: Int,
    val link: String,
    val location: String,
    val profileImage: String,
    val reputation: Int,
    val reputationChangeDay: Int,
    val reputationChangeMonth: Int,
    val reputationChangeQuarter: Int,
    val reputationChangeWeek: Int,
    val reputationChangeYear: Int,
    val userId: Int,
    val userType: String,
    val websiteUrl: String
)

data class BadgeCounts(
    val bronze: Int,
    val gold: Int,
    val silver: Int
)