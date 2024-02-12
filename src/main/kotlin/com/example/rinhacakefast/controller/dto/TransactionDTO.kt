package com.example.rinhacakefast.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.stereotype.Service

data class TransactionRequestDTO(
    @JsonProperty("valor")
    val amount: Long,

    @JsonProperty("tipo")
    val type: String,

    @JsonProperty("descricao")
    val description: Long
)

data class TransactionResponseDTO(
    @JsonProperty("limite")
    val limit: Long,

    @JsonProperty("saldo")
    val balance: Long
)

enum class TransactionType(acronym: String) {
    CREDIT("c"),
    DEBIT("d")
}
