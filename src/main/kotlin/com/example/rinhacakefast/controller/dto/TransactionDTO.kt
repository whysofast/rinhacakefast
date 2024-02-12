package com.example.rinhacakefast.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TransactionRequestDTO(
    @JsonProperty("valor")
    val amount: Long,

    @JsonProperty("tipo")
    val type: String,

    @JsonProperty("descricao")
    val description: String
)

data class TransactionResponseDTO(
    @JsonProperty("limite")
    val limit: Long,

    @JsonProperty("saldo")
    val balance: Long
)
