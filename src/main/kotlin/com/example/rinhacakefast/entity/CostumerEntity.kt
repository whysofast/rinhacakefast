package com.example.rinhacakefast.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "costumer")
data class CostumerEntity(
    @Id
    val id: Long,

    val limit: Long,

    val initialBalance: Long
)