package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a512lasalleapp.R


@Composable
fun GradesScreen(navController: NavController) {
    val studentName = "José Alfredo Arriaga Rosillo"
    val major = "Ingeniería en Software"
    val semester = "5° Semestre"
    val gpa = "8.5"
    val subjects = listOf(
        "Matemáticas Avanzadas" to 9.0,
        "Sistemas Operativos" to 8.7,
        "Bases de Datos" to 9.2,
        "Programación Avanzada" to 8.5
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

        // Contenido del GradesScreen encima de la imagen de fondo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Información del estudiante con texto en blanco
            Text(
                text = studentName,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White // Texto en blanco
            )
            Text(
                text = "$major, $semester",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White // Texto en blanco
            )
            Text(
                text = "Promedio Acumulado: $gpa",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White // Texto en blanco
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Lista de materias con promedio
            LazyColumn {
                items(subjects) { subject ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate("SubjectDetailScreen/${subject.first}") }
                            .padding(vertical = 16.dp), // Espacio vertical
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = subject.first,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White // Texto en blanco
                        )
                        Text(
                            text = "Promedio: ${subject.second}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White // Texto en blanco
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp)) // Espaciado entre filas
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GradesScreenPreview() {
    val navController = rememberNavController()
    GradesScreen(navController)
}
