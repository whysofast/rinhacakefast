package com.example.rinhacakefast.repository

import com.example.rinhacakefast.entity.CostumerEntity
import com.example.rinhacakefast.entity.TransactionEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CostumerRepository : ReactiveMongoRepository<CostumerEntity, Long>

@Repository
interface TransactionRepository : ReactiveMongoRepository<TransactionEntity, String> {

    fun findByCostumerId(costumerId: Long): Flux<TransactionEntity>
}