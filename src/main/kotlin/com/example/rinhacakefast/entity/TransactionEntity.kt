package com.example.rinhacakefast.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "transaction")
data class TransactionEntity(
    @Id
    val id: String? = null,

    val costumerId: Long,

    val amount: Long,

    val type: String,

    val description: String,

    @CreatedDate
    val createdAt: LocalDateTime? = null
)
