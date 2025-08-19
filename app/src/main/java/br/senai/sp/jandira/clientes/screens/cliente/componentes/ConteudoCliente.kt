package br.senai.sp.jandira.clientes.screens.cliente.componentes

import android.icu.text.UnicodeSet.SpanCondition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns
import br.senai.sp.jandira.clientes.model.Cliente
import br.senai.sp.jandira.clientes.service.Conexao
import br.senai.sp.jandira.clientes.ui.theme.ClientesTheme
import kotlinx.coroutines.Dispatchers
import retrofit2.await

@Composable
fun ConteudoCliente(paddingValues: PaddingValues) {

    val clienteApi = Conexao().getClienteService()

    var clientes by remember {
        mutableStateOf(listOf<Cliente>())
    }

    LaunchedEffect(Dispatchers.IO) {
        clientes = clienteApi.listarTodos().await()
    }

    Column (
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ){
        Row (
            modifier = Modifier .padding(10.dp)
        ){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person"
            )
            Spacer(modifier = Modifier .padding(horizontal = 4.dp))
            Text(text = "Lista de Cliente",
                style = MaterialTheme.typography.titleLarge)
        }
        LazyColumn {
            items (clientes){ cliente ->
                Card (
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        )
                        .fillMaxWidth()
                        .height(80.dp)
                ){
                    Row (
                        modifier = Modifier .fillMaxSize().padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Column {
                            Text(text = cliente.nome,
                                style = MaterialTheme.typography.titleLarge)
                            Text(text = cliente.email)

                        }
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "person"
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Composable
private fun ConteudoClientePreview() {

    ClientesTheme {
        ConteudoCliente(PaddingValues(16.dp))
    }

}