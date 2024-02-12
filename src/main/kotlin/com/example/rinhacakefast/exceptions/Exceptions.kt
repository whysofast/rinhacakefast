package com.example.rinhacakefast.exceptions

sealed class DomainException(override val message: String?): RuntimeException(message)

class CostumerNotFoundException(override val message: String?): DomainException(message)