package id.ac.unpas.tokoelektronik.screens

import id.ac.unpas.tokoelektronik.model.Periferal
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.message
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import com.vanpra.composematerialdialogs.title

@Composable
fun PeriferalItem (item: Periferal, navController: NavHostController, onDelete: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val subMenus = listOf("Edit", "Delete")
    val confirmationDialogState = rememberMaterialDialogState()
    Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("edit-periferal/${item.id}")
                },
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color(0xFF6200EE)
        ) {
            Row(modifier = Modifier.padding(15.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Nama", fontWeight = FontWeight.Bold)
                    Text(text = "Harga", fontWeight = FontWeight.Bold)
                    Text(text = "Deskripsi", fontWeight = FontWeight.Bold)
                    Text(text = "Jenis", fontWeight = FontWeight.Bold)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = item.nama, fontSize = 16.sp)
                    Text(text = item.harga.toString(), fontSize = 16.sp)
                    Text(text = item.deskripsi, fontSize = 16.sp)
                    Text(text = item.jenis, fontSize = 16.sp)
                }
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clickable {
                                expanded = true
                            }
                    ) {
                        Icon(
                            Icons.Default.AddCircle,
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(24.dp),
                            tint = Color.White
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        offset = DpOffset(x = (-66).dp, y = (-10).dp)
                    ) {
                        subMenus.forEachIndexed { _, s ->
                            DropdownMenuItem(onClick = {
                                expanded = false
                                when (s) {
                                    "Edit" -> {
                                        navController.navigate("edit-periferal/${item.id}")
                                    }
                                    "Delete" -> {
                                        confirmationDialogState.show()
                                    }
                                }
                            }) {
                                Text(text = s)
                            }
                        }
                    }
                }
            }
        }

        MaterialDialog(dialogState = confirmationDialogState,
            buttons = {
                positiveButton("Ya", onClick = {
                    onDelete(item.id)
                })
                negativeButton("Tidak")
            }) {
            title(text = "Konfirmasi")
            message(text = "Yakin Menghapus Data?")
        }
    }
}