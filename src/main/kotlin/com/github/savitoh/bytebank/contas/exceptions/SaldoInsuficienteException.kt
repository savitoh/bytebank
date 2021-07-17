package com.github.savitoh.bytebank.contas.exceptions

class SaldoInsuficienteException(
    mesage: String = "O Saldo é insuficiente") : Exception(mesage)