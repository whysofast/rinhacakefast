package com.example.rinhacakefast.repository

import com.example.rinhacakefast.service.CostumerEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CostumerRepository : ReactiveCrudRepository<CostumerEntity, Long>
