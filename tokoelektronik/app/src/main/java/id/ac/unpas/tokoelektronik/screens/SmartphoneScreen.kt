package id.ac.unpas.tokoelektronik.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import id.ac.unpas.tokoelektronik.model.SmartPhone
import kotlinx.coroutines.launch
import id.ac.unpas.tokoelektronik.screens.SmartphoneViewModel

@Composable
fun SmartphoneScreen(navController : NavHostController, modifier: Modifier = Modifier, snackbarHostState: SnackbarHostState) {
    val viewModel = hiltViewModel<SmartphoneViewModel>()
    val scope = rememberCoroutineScope()
    val items: List<SmartPhone> by viewModel.list.observeAsState(initial = listOf())

    Column(modifier = modifier.fillMaxWidth()) {
        Button(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            onClick = {
                navController.navigate("tambah-smartphone")
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF3700B3)), // Warna latar belakang tombol
            shape = RoundedCornerShape(8.dp) // Bentuk tombol yang melengkung
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Plus",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp) // Ukuran ikon
                )
                Text(
                    text = "Tambah Data",
                    modifier = Modifier.padding(start = 4.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold // Memberikan teks dengan ketebalan teks yang tebal
                )
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                SmartphoneItem(item = item, navController = navController) {
                    scope.launch {
                        viewModel.delete(it)
                    }
                }
            })
        }
    }
    LaunchedEffect(scope) {
        viewModel.loadItems()
    }
    viewModel.success.observe(LocalLifecycleOwner.current) {
        if (it) {
            scope.launch {
                viewModel.loadItems()
            }
        }
    }
    viewModel.toast.observe(LocalLifecycleOwner.current) {
        scope.launch {
            snackbarHostState.showSnackbar(it, actionLabel =
            "Tutup", duration = SnackbarDuration.Long)
        }
    }
}