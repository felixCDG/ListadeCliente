package br.senai.sp.jandira.clientes.screens.cliente

import android.content.res.Configuration
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.clientes.screens.cliente.componentes.BarraInferior
import br.senai.sp.jandira.clientes.screens.cliente.componentes.BarradeTitulo
import br.senai.sp.jandira.clientes.screens.cliente.componentes.BotaoFlutuante
import br.senai.sp.jandira.clientes.screens.cliente.componentes.ConteudoCliente
import br.senai.sp.jandira.clientes.ui.theme.ClientesTheme

@Composable
fun Listadeclientes(modifier: Modifier = Modifier) {

    var ControleNavegacao = rememberNavController()

    Scaffold (
        topBar = {
            BarradeTitulo()
        },
        bottomBar = {
            BarraInferior(ControleNavegacao)
        },
        floatingActionButton = {
            BotaoFlutuante(ControleNavegacao)
        },
        content = { padding ->
          NavHost(
              navController = ControleNavegacao,
              startDestination = "conteudo"
          ){
              composable(route = "conteudo") { ConteudoCliente(padding, ControleNavegacao) }
              composable(route = "cadastro") { ClienteForm(padding, ControleNavegacao) }
          }
        }
    )

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ListadeclientePreview() {

    ClientesTheme {
        Listadeclientes()
    }
}