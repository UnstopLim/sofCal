package com.example.softcal.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.softcal.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun view2(
    navController: NavController
) {
    var estado1 by remember { mutableStateOf("") }
    var estado2 by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize())
    {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.cuatro), // Reemplaza con el nombre de tu imagen
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido principal
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp))
        {

            item {
                Row(modifier = Modifier.fillMaxWidth()) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "atras")
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.new14),
                        contentDescription = "logoPerfil",
                        modifier = Modifier
                            .size(180.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(35.dp))
                    Text(text = "UnstopLim/", fontSize = 45.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Limber Mamani Canaza", fontSize = 20.sp)
                    Text(text = "Datos personales", fontFamily = FontFamily.Cursive)
                }
                Spacer(modifier = Modifier.height(40.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "          |  Vive en La Paz")
                    Text(text = "          |  De La Paz")
                    Text(text = "          |  draw.redmi8@gmail.com  ")
                    Text(text = "          |  24 Años  ")
                    Text(text = "          |  Developer  ")
                }
                Spacer(modifier = Modifier.height(25.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = estado2, fontSize = 50.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(value = estado1, onValueChange = { estado1 = it }
                    , label = {Text(text = "Ingrese un valor")},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    OutlinedButton(onClick = {
                        estado2 = estado1
                        estado1=""
                    }) {
                        Text(text = "Agregar Calificacion")
                    }
                    Spacer(modifier = Modifier.height(25.dp))
            }

            }
        }
    }



}

@Preview(showBackground = true)
@Composable
fun view2Preview() {

}
