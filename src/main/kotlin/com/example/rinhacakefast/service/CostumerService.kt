package com.example.rinhacakefast.service

import com.example.rinhacakefast.controller.dto.BankStatementResponseDTO
import com.example.rinhacakefast.controller.dto.TransactionRequestDTO
import com.example.rinhacakefast.controller.dto.TransactionResponseDTO
import com.example.rinhacakefast.repository.CostumerRepository
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.stereotype.Service


@Service
class CostumerService(private val costumerRepository: CostumerRepository) {

    fun getBankStatement(costumerId: Long): BankStatementResponseDTO? {
        TODO()
    }

    fun createTransaction(costumerId: Long, transactionRequestDTO: TransactionRequestDTO): TransactionResponseDTO {
        TODO()
    }
}

@Document(collection = "costumer")
data class CostumerEntity(
    @Id
    val id: Long,

    val limit: Long,

    val initialBalance: Long
)
