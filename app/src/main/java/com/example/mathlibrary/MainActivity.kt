package com.example.mathlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mathlib.MathUtils
import com.example.mathlibrary.ui.theme.MathLibraryTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val snackBarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            MathLibraryTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackBarHostState) }
                ) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding).padding(16.dp)
                    ) {
                        scope.launch {
                            snackBarHostState.showSnackbar(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, onError: (String) -> Unit) {
    Column(
        modifier = modifier
    ) {

        Text(
            text = "Exemplo para a demostração de uso da lib",
        )

        var value1 by remember { mutableIntStateOf(0) }
        var value2 by remember { mutableIntStateOf(0) }
        var value3 by remember { mutableIntStateOf(0) }

        OutlinedTextField(
            value = value1.toString(),
            onValueChange = { newValue ->
                value1 = newValue.toIntOrNull() ?: 0
            },
            label = { Text("Valor 1") },
            placeholder = { Text("Digite um número") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedTextField(
            value = value2.toString(),
            onValueChange = { newValue ->
                value2 = newValue.toIntOrNull() ?: 0
            },
            label = { Text("Valor 2") },
            placeholder = { Text("Digite um número") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )

        Button(onClick = {
            try {
                value3 = MathUtils.sum(value1, value2)
            } catch (_: Exception) {
                onError("Erro de valores")
            }
        }) {
            Text("Somar")
        }

        Text(
            text = "Resultado: $value3",
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MathLibraryTheme {
        Greeting {}
    }
}