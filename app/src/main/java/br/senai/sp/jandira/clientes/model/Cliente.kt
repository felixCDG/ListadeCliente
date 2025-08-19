package br.senai.sp.jandira.clientes.model

data class Cliente(
    val id: Long? = 0,
    val nome: String = "",
    val email: String = "",
)
