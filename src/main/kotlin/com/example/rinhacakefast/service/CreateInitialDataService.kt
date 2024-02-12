package com.example.rinhacakefast.service

import com.example.rinhacakefast.entity.CostumerEntity
import com.example.rinhacakefast.repository.CostumerRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class CreateInitialDataService(
    private val costumerRepository: CostumerRepository
) {
    @PostConstruct
    fun start() {
        println("Creating initial Data")

        costumerRepository.deleteAll().subscribe()

        costumerRepository.saveAll(
            listOf(
                CostumerEntity(id = 1, limit = 100000, initialBalance = 0),
                CostumerEntity(id = 2, limit = 80000, initialBalance = 0),
                CostumerEntity(id = 3, limit = 1000000, initialBalance = 0),
                CostumerEntity(id = 4, limit = 10000000, initialBalance = 0),
                CostumerEntity(id = 5, limit = 500000, initialBalance = 0)
            )
        ).subscribe()

        println("Created initial Data")
    }
}