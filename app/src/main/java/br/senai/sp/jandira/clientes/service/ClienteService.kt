package br.senai.sp.jandira.clientes.service

import android.telecom.Call
import br.senai.sp.jandira.clientes.model.Cliente
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ClienteService {
    @POST("clientes")
    fun cadastrarCliente(@Body cliente: Cliente): retrofit2.Call<Cliente>

    @GET("clientes")
    fun listarTodos(): retrofit2.Call<List<Cliente>>

    @GET("clientes/{id}")
    fun buscarPorId(@Path("id") id: Long): retrofit2.Call<Cliente>

    @PUT("clientes")
    fun atualizar(@Body cliente: Cliente): retrofit2.Call<Cliente>

    @DELETE("clientes")
    fun excluir(@Body cliente: Cliente):Unit
}