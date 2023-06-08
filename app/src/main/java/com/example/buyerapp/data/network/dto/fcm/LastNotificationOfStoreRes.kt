package com.example.buyerapp.data.network.dto.fcm

import com.example.buyerapp.data.network.dto.PageableContent
import com.example.buyerapp.data.network.dto.StoreRes
import com.example.buyerapp.data.network.dto.toDomain
import com.example.buyerapp.domain.model.Pageable
import com.example.buyerapp.domain.model.fcm.LastNotificationOfStore

data class LastNotificationOfStoreRes (
    val body: String,
    val id: Long,
    val imageUrl: String,
    val sentDate: String,
    val store: StoreRes,
    val title: String
)

fun LastNotificationOfStoreRes.toDomain() =
    LastNotificationOfStore(
        body,
        id,
        imageUrl,
        sentDate,
        store = store.toDomain(),
        title
    )

fun List<LastNotificationOfStoreRes>.toDomain() = map { it.toDomain()}

fun PageableContent<LastNotificationOfStoreRes>.toDomain() = Pageable(
    content?.toDomain() ?: listOf(),
    totalPages,
    number
)