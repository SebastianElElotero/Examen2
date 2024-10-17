package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a512lasalleapp.R
import com.example.a512lasalleapp.ui.utils.Screens

@Composable
fun ConfigureScreen(navController: NavController) {
    val studentName = "Sebastian Rodriguez Martinez"
    val birthDate = "17/01/2004"
    val email = "Sebas76734@lasallebajio.edu.mx"

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo que ocupa toda la pantalla
        Image(
            painter = painterResource(id = R.drawable.background_image), // Usa tu recurso de imagen de fondo
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop, // Para que la imagen cubra todo el espacio
            modifier = Modifier.fillMaxSize() // Ocupa toda la pantalla
        )

        // Contenido del ConfigScreen encima de la imagen de fondo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally // O alinear como prefieras
        ) {
            // Imagen del alumno (sin círculo)
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Student Image",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Start) // Alinea solo la imagen a la izquierda
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Información del alumno con tipografía blanca
            Text(
                text = studentName,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White // Texto en blanco
            )
            Text(
                text = "Fecha de Nacimiento: $birthDate",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White // Texto en blanco
            )
            Text(
                text = "Email: $email",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White // Texto en blanco
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Opciones con espacio entre cada elemento y tipografía blanca
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screens.PasswordScreen.route) }
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cambiar Contraseña",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White // Texto en blanco
                )
                Icon(tint = Color.White, painter = painterResource(id = R.drawable.ic_arrow_forward_b), contentDescription = "Ir a cambiar contraseña")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screens.TemaScreen.route) }
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cambiar Tema de la Aplicación",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White // Texto en blanco
                )
                Icon(tint = Color.White,painter = painterResource(id = R.drawable.ic_arrow_forward_b), contentDescription = "Ir a cambiar tema")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ConfigureScreenPreview() {
    val navController = rememberNavController()
    ConfigureScreen(navController)
}
