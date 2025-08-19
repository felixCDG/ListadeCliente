package br.senai.sp.jandira.clientes.screens.cliente.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import br.senai.sp.jandira.clientes.ui.theme.ClientesTheme

@Composable
fun BotaoFlutuante(ControleNavegacao: NavHostController?) {

    FloatingActionButton(
        onClick = {
            ControleNavegacao!!.navigate("cadastro")
        }
    ) {
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = ""
        )
    }

}

@Preview
@Composable
private fun BotaoFlutuantePreview() {

    ClientesTheme {
        BotaoFlutuante(null)
    }

}