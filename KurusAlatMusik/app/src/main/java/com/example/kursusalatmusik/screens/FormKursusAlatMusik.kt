package com.example.kursusalatmusik.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import com.example.kursusalatmusik.model.KursusAlatMusik
import com.example.kursusalatmusik.persistences.KursusAlatMusikDao
import com.example.kursusalatmusik.ui.theme.Purple700
import com.example.kursusalatmusik.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormKursusAlatMusik(kursusAlatMusikDao: KursusAlatMusikDao) {
    val scope = rememberCoroutineScope()
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val jeniskelamin = remember { mutableStateOf(TextFieldValue("")) }
    val nohp = remember { mutableStateOf(TextFieldValue("")) }
    val alatmusik = listOf("Gitar", "Bass", "Drum", "Biola", "Piano")
    var expanded by remember { mutableStateOf(false) }
    var selectedalatmusik by remember { mutableStateOf("") }
    val jamkursus = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "nama") }
        )
        OutlinedTextField(
            label = { Text(text = "jenis kelamin") },
            value = jeniskelamin.value,
            onValueChange = {
                jeniskelamin.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "Hp") },
            value = nohp.value,
            onValueChange = {
                nohp.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "5") }

        )


        TextField(
            label = { Text(text = "Alat musik") },
            value = selectedalatmusik,
            onValueChange = { selectedalatmusik = it },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                Icon(Icons.Filled.ArrowDropDown, contentDescription = "Expand", modifier = Modifier.clickable {
                    expanded = true
                })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            alatmusik.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedalatmusik = option
                        expanded = false
                    }
                ) {
                    Text(text = option)
                }
            }
        }

        OutlinedTextField(
            label = { Text(text = "jam") },
            value = jamkursus.value,
            onValueChange = {
                jamkursus.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "nama") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {

                val id = uuid4().toString()
                val item = KursusAlatMusik(id, nama.value.text, jeniskelamin.value.text,
                    nohp.value.text, selectedalatmusik, jamkursus.value.text)
                scope.launch {
                    kursusAlatMusikDao.insertAll(item)
                }

                nama.value = TextFieldValue("")
                jeniskelamin.value = TextFieldValue("")
                nohp.value = TextFieldValue("")
                selectedalatmusik = ("")
                jamkursus.value = TextFieldValue("")


            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                nama.value = TextFieldValue("")
                jeniskelamin.value = TextFieldValue("")
                nohp.value = TextFieldValue("")
                selectedalatmusik = ("")
                jamkursus.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}