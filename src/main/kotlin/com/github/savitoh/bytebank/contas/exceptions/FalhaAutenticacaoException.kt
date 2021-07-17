package com.github.savitoh.bytebank.contas.exceptions

class FalhaAutenticacaoException(
    mesage: String = "Falha na autenticação"
) : Exception(mesage)