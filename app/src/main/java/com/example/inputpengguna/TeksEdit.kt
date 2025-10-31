package com.example.inputpengguna


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormDataDiri(modifier: Modifier){
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatusKawin by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var statusKawin by remember { mutableStateOf("") }

    val genderOptions: List<String> = listOf("Laki-laki", "Perempuan")
    val statusKawinOptions: List<String> = listOf("Janda", "Lajang", "Duda")

    val warnaUnguPucat = Color(0xFFF3E5F5)
    Column(
        modifier = modifier

            .background(warnaUnguPucat)


            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Formulir Pendaftaran",
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 32.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "NAMA LENGKAP",
                modifier = Modifier
                    .align(Alignment.Start) // Rata kiri untuk judul bagian
                    .padding(bottom = 8.dp, start = 8.dp)
            )
            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth() // Mengisi lebar penuh
                    .padding(horizontal = 8.dp),
                label = { Text(text = "Isian nama lengkap") },
                onValueChange = {
                    textNama = it
                }
            )
            Text(
                text = "JENIS KELAMIN",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 24.dp, bottom = 8.dp, start = 8.dp)
            )
            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top
            ) {
                genderOptions.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        )
                        Text(
                            text = item,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

