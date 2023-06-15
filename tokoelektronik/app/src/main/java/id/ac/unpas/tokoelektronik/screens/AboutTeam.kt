package id.ac.unpas.tokoelektronik.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutTeam() {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Farriz Brilliant Wicaksana",fontSize = 18.sp,fontWeight = FontWeight.Bold)
        Text(text = "Paiz Abdul Jabar", fontSize = 18.sp,fontWeight = FontWeight.Bold)
        Text(text = "Marwan Hakim", fontSize = 18.sp,fontWeight = FontWeight.Bold)
        Text(text = "Dika Sulaeman Akbar", fontSize = 18.sp,fontWeight = FontWeight.Bold)
        Text(text = "Muhamad Rafliansyah", fontSize = 18.sp,fontWeight = FontWeight.Bold)
    }
}