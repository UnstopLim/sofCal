package com.example.softcal.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.PopupProperties
import com.example.softcal.R
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import kotlin.math.pow



import androidx.compose.material3.DrawerValue
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState




@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun view1(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
    drawerState = drawerState,
    drawerContent = {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.75f) // El drawer ocupará el 75% del ancho de la pantalla
                .background(Color(0xFFCECCCC))
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Text(
                text = "UnstopLim",
                fontSize = 30.sp,
                color = Color(0xFF212121),
                modifier = Modifier.padding(8.dp)
            )
            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))

            DrawerItem(
                text = "Usuario",
                icon = Icons.Default.AccountCircle,
                onClick = {
                    scope.launch {
                        drawerState.close()
                        navController.navigate("view2")
                    }
                }
            )

            DrawerItem(
                text = "Detalles",
                icon = Icons.Default.Info,
                onClick = {
                    scope.launch {
                        drawerState.close()
                        navController.navigate("view3")
                    }
                }
            )

        }
    }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "UnstopLim",
                            fontFamily = FontFamily.Cursive,
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.LightGray),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu, // Icono para abrir el drawer
                                contentDescription = "Abrir drawer",
                                tint = Color.Black
                            )
                        }
                    }
                )
            },
        ) { innerPadding ->
            // Contenido de la vista principal
            dato(innerPadding)
        }
    }
}

@Composable
fun DrawerItem(text: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp)
            .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = text, tint = Color(0xFF000E58))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, color = Color(0xFF212121), fontSize = 18.sp)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dato(it: PaddingValues) {

    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var num3 by remember { mutableStateOf("") }
    var total by remember { mutableIntStateOf(0) }
    var count by remember { mutableIntStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Paramatro ▼") }
    val opciones = listOf("Organico", "SemiAcoplado", "Acoplado")
    var errorMessage by remember { mutableStateOf("") }
    var valor = ""
    var a by remember { mutableDoubleStateOf(0.0) }
    var b by remember { mutableDoubleStateOf(0.0) }
    var c by remember { mutableDoubleStateOf(0.0) }
    var d by remember { mutableDoubleStateOf(0.0) }
    var num1Error by remember { mutableStateOf(false) }
    var num2Error by remember { mutableStateOf(false) }
    var num3Error by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize())
    {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.cuatro), // Reemplaza con el nombre de tu imagen
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {


                    LazyRow(modifier = Modifier.fillMaxWidth()){
                        item {
                            Spacer(modifier = Modifier.width(115.dp))
                            Image(
                                painter = painterResource(id = R.drawable.mo2),
                                contentDescription = "#imagen1",
                                modifier = Modifier
                                    .padding(top = 50.dp, bottom = 30.dp)
                                    .size(130.dp)
                            )
                            Spacer(modifier = Modifier.width(115.dp))
                            Image(
                                painter = painterResource(id = R.drawable.mo4),
                                contentDescription = "#imagen1",
                                modifier = Modifier
                                    .padding(top = 50.dp, bottom = 30.dp)
                                    .size(130.dp)
                            )
                            Spacer(modifier = Modifier.width(115.dp))
                            Image(
                                painter = painterResource(id = R.drawable.mo5),
                                contentDescription = "#imagen1",
                                modifier = Modifier
                                    .padding(top = 50.dp, bottom = 30.dp)
                                    .size(130.dp)
                            )
                            Spacer(modifier = Modifier.width(115.dp))
                        }

                    }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                ) {
                    OutlinedTextField(
                        value = num1,
                        onValueChange = {
                            num1 = it
                            num1Error = num1.isEmpty() || num1.toIntOrNull()?.let { it < 0 } == true
                        },
                        label = { Text(text = "Datos entrada") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "num1"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp), shape = RoundedCornerShape(26.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.White),
                        isError = num1Error
                    )
                    if (num1Error) {
                        Text(
                            text = if (num1.isEmpty()) "Debe ingresar un valor de entrada" else "El valor no puede ser negativo",
                            color = Color.Red,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    OutlinedTextField(
                        value = num2,
                        onValueChange = {
                            num2 = it
                            num2Error = num2.isEmpty() || num2.toIntOrNull()?.let { it < 0 } == true
                        },
                        label = { Text(text = "Datos salida") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "num2"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp), shape = RoundedCornerShape(26.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.White),
                        isError = num2Error
                    )
                    if (num2Error) {
                        Text(
                            text = if (num2.isEmpty()) "Debe ingresar un valor de salida" else "El valor no puede ser negativo",
                            color = Color.Red,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    OutlinedTextField(
                        value = num3,
                        onValueChange = {
                            num3 = it
                            num3Error = num3.isEmpty() || num3.toIntOrNull()?.let { it < 0 } == true
                        },
                        label = { Text(text = "Datos salario SH") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "num3"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 45.dp), shape = RoundedCornerShape(26.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.White),
                        isError = num3Error
                    )
                    if (num3Error) {
                        Text(
                            text = if (num3.isEmpty()) "Debe ingresar un valor de salario" else "El valor no puede ser negativo",
                            color = Color.Red,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }


                Divider()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedButton(
                            onClick = {
                                when (valor) {
                                    "Organico" -> {
                                        if (count >= 51 && count < 80) count += 1
                                    }

                                    "SemiAcoplado" -> {
                                        if (count >= 81 && count < 100) count += 1
                                    }

                                    "Acoplado" -> {
                                        if (count >= 101 && count < 150) count += 1
                                    }
                                }
                            },
                            modifier = Modifier.padding(14.dp)
                        ) {
                            Text("▲")
                        }
                        Text(
                            text = count.toString(),
                            fontSize = 34.sp
                        )
                        OutlinedButton(
                            onClick = {
                                when (valor) {
                                    "Organico" -> {
                                        if (count >= 52 && count <= 80) count -= 1
                                    }

                                    "SemiAcoplado" -> {
                                        if (count >= 82 && count <= 100) count -= 1
                                    }

                                    "Acoplado" -> {
                                        if (count >= 102 && count <= 150) count -= 1
                                    }
                                }
                            },
                            modifier = Modifier.padding(14.dp)
                        ) {
                            Text("▼")
                        }
                    }

                    Box() {
                        OutlinedButton(
                            onClick = { expanded = true },
                            modifier = Modifier
                                .padding(20.dp)
                                .clip(CircleShape)
                        ) {
                            Text(
                                text = selectedOption,
                                fontSize = 16.sp,
                                color = Color.White,
                                modifier = Modifier.padding(6.dp)
                            )
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            properties = PopupProperties(focusable = false),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Color.White)
                        ) {
                            opciones.forEach { opcion ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedOption = opcion
                                        expanded = false
                                        when (opcion) {
                                            "Organico" -> {
                                                valor = "Organico"
                                                count = 51
                                                a = 3.2
                                                b = 1.05
                                                c = 2.5
                                                d = 0.38
                                            }

                                            "SemiAcoplado" -> {
                                                valor = "SemiAcoplado"
                                                count = 81
                                                a = 3.0
                                                b = 1.12
                                                c = 2.5
                                                d = 0.35
                                            }

                                            "Acoplado" -> {
                                                valor = "Acoplado"
                                                count = 101
                                                a = 2.8
                                                b = 1.20
                                                c = 2.5
                                                d = 0.32
                                            }
                                        }
                                    },
                                    text = { Text(opcion, color = Color.Black) })
                            }
                        }
                    }
                }

                Divider()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp), contentAlignment = Alignment.BottomCenter
                ) {
                    Button(onClick = {
                        if (num1.isEmpty() || num2.isEmpty() || num3.isEmpty()) {
                            errorMessage = "Todos los campos deben estar llenos"
                            num1Error = num1.isEmpty()
                            num2Error = num2.isEmpty()
                            num3Error = num3.isEmpty()
                        } else {
                            errorMessage = ""
                            showDialog = true
                            total = num1.toInt() + num2.toInt()
                        }
                    },
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .size(width = 160.dp, height = 45.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFCECCCC),
                            contentColor = Color.White
                        )
                        ) {
                        Text(text = "Resolver ->", fontSize = 15.sp, color = Color.Black)
                    }

                    // Mostrar el diálogo si showDialog es verdadero
                    if (showDialog) {
                        CustomDialog(
                            onDismiss = { showDialog = false },
                            total,
                            num3,
                            count,
                            a,
                            b,
                            c,
                            d
                        )
                    }
                }

                if (errorMessage.isNotEmpty()) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(text = errorMessage, color = Color.Red)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun CustomDialog(
    onDismiss: () -> Unit,
    total: Int,
    num3: String,
    cont: Int,
    a: Double,
    b: Double,
    c: Double,
    d: Double
) {

    var LDC = 0.0
    var MLDC = 0.0
    var EI = 0.0
    var TD = 0.0
    var PN = 0.0
    var P = 0.0
    var C = 0.0
    var CLDC = 0.0

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = Color.White,
            shadowElevation = 24.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Resultados",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                )
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                LDC = total.toDouble() * cont.toDouble()
                MLDC = LDC / 1000
                EI = a * MLDC.pow(b)
                TD = c * EI.pow(d)
                PN = EI / TD
                P = LDC / EI
                C = num3.toDouble() * EI
                CLDC = C/LDC

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "LDC    = ${"%.2f".format(LDC)}", color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "MLDC = ${"%.2f".format(MLDC)}", color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "EI        = ${"%.2f".format(EI)} Personas", color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "TD      = ${"%.2f".format(TD)} Meses", color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "PN      = ${"%.2f".format(PN)} LDC al mes", color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "P        = ${"%.2f".format(P)}", color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "C        = ${"%.2f".format(C)} Bs", color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "CLDC = ${"%.2f".format(CLDC)} Bs", color = Color.Black)

                }
                Divider()

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(text = "Aceptar", color = Color.Black,fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun viewV() {


    val navController = rememberNavController()
    view1(navController)

}






















