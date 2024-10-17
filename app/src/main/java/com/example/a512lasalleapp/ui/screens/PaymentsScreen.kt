package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a512lasalleapp.R



@Composable
fun PaymentsScreen() {
    val months = listOf(
        "Enero" to true,
        "Febrero" to false,
        "Marzo" to true,
        "Abril" to false
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo que ocupa toda la pantalla
        Image(
            painter = painterResource(id = R.drawable.background_image), // Cambia por tu imagen de fondo
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop, // Para que la imagen cubra todo el espacio
            modifier = Modifier.fillMaxSize() // Ocupa toda la pantalla
        )

        // Contenido del PaymentsScreen encima de la imagen de fondo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Pagos",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White // Texto en blanco
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de meses y estado de pagos
            LazyColumn {
                items(months) { month ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp), // Espacio vertical
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = month.first,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White // Texto en blanco
                        )

                        if (month.second) {
                            Icon(
                                Icons.Default.Check,
                                contentDescription = "Pagado",
                                tint = Color.Green
                            )
                        } else {
                            Icon(
                                Icons.Default.Warning,
                                contentDescription = "Pendiente",
                                tint = Color.Red
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp)) // Espaciado entre filas
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PaymentsScreenPreview() {
    PaymentsScreen()
}
