package com.example.softcal.componentes


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.navigation.compose.rememberNavController
import com.example.softcal.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun view3(
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
                Spacer(modifier = Modifier.height(140.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ing),
                        contentDescription = "logoPerfil",
                        modifier = Modifier
                            .size(180.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(35.dp))
                    Text(text = "   Sabes cual es el problema ", fontSize = 25.sp, fontFamily = FontFamily.Cursive)
                    Text(text = "   Imaginarte el algoritmo y no ", fontSize = 25.sp, fontFamily = FontFamily.Cursive)
                    Text(text = "   Programarlo", fontSize = 25.sp, fontFamily = FontFamily.Cursive)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "- Adelante Ingenieria -", fontSize = 10.sp, fontFamily = FontFamily.Monospace)

                }


                Spacer(modifier = Modifier.height(15.dp))




            }
        }
    }



}
@Preview(showBackground = true)
@Composable
fun view3V() {
    val navController = rememberNavController()
    view3(navController)

}
