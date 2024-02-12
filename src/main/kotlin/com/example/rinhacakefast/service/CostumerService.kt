package com.example.rinhacakefast.service

import com.example.rinhacakefast.controller.dto.TransactionRequestDTO
import com.example.rinhacakefast.controller.dto.TransactionResponseDTO
import com.example.rinhacakefast.entity.TransactionEntity
import com.example.rinhacakefast.exceptions.CostumerNotFoundException
import com.example.rinhacakefast.repository.CostumerRepository
import com.example.rinhacakefast.repository.TransactionRepository
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactive.collect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CostumerService(
    private val costumerRepository: CostumerRepository,
    private val transactionRepository: TransactionRepository
) {

    private val logger = LoggerFactory.getLogger(CostumerService::class.java)

    suspend fun getBankStatement(costumerId: Long)
//    : BankStatementResponseDTO?
    {
        val costumer = findCostumerById(costumerId)

        val transactions = findTransactionsByCostumerId(costumerId, 10)

        logger.info(costumer.toString())
        logger.info(transactions.toString())
    }

    suspend fun createTransaction(
        costumerId: Long,
        transactionRequestDTO: Mono<TransactionRequestDTO>
    ): TransactionResponseDTO {
        logger.info("aaaaaaaau")
        val costumer = findCostumerById(costumerId)

        transactionRequestDTO.collect {
            transactionRepository.save(
                TransactionEntity(
                    costumerId = costumer.id,
                    amount = it.amount,
                    type = it.type,
                    description = it.description
                )
            ).subscribe()
        }

        return TransactionResponseDTO(
            limit = 0,
            balance = 0
        ).also { logger.info("paysanduUUUUUUUUUUUU") }
    }

    private fun findCostumerById(costumerId: Long) = costumerRepository.findById(costumerId)
        .blockOptional()
        .orElseThrow { throw CostumerNotFoundException("costumer $costumerId not found") }

    private suspend fun findTransactionsByCostumerId(costumerId: Long, limit: Int) =
        transactionRepository.findByCostumerId(costumerId)
            .collectList()
            .awaitSingle()
            .toList()
}
