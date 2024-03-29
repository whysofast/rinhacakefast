@file:Suppress("SpellCheckingInspection")

package com.example.rinhacakefast.controller

import com.example.rinhacakefast.controller.dto.BankStatementResponseDTO
import com.example.rinhacakefast.controller.dto.TransactionRequestDTO
import com.example.rinhacakefast.controller.dto.TransactionResponseDTO
import com.example.rinhacakefast.service.CostumerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/clientes")
class CostumerController(
    private val costumerService: CostumerService

) {

    @GetMapping("{id}/extrato")
    suspend fun getBankStatement(
        @PathVariable("id") costumerId: Long
    ): ResponseEntity<BankStatementResponseDTO>? {
        costumerService.getBankStatement(costumerId)
        return null
    }

    @PostMapping("{id}/transacoes")
    suspend fun createTransaction(
        @PathVariable("id") costumerId: Long,
        @RequestBody transactionRequest: Mono<TransactionRequestDTO>
    ): ResponseEntity<TransactionResponseDTO> {

//        ResponseEntity.ok(costumerService.createTransaction(costumerId, transactionRequest))
        return ResponseEntity.ok(costumerService.createTransaction(costumerId, transactionRequest))
    }
}
