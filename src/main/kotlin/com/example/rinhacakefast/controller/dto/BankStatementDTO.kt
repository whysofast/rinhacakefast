package com.example.rinhacakefast.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime


data class BankStatementResponseDTO(
    @JsonProperty("saldo")
    val balance: BalanceDTO,
    @JsonProperty("ultimas_transacoes")
    val lastTransactions: List<SettledTransactionDTO>
)

data class BalanceDTO(
    @JsonProperty("total")
    val total: Long,

    @JsonProperty("data_extrato")
    val bankStatementDate: ZonedDateTime,

    @JsonProperty("limite")
    val limit: Long,
)

data class SettledTransactionDTO(
    @JsonProperty("valor")
    val amount: Long,

    @JsonProperty("tipo")
    val type: String,

    @JsonProperty("descricao")
    val description: String,

    @JsonProperty("realizada_em")
    val occurredAt: ZonedDateTime
)
