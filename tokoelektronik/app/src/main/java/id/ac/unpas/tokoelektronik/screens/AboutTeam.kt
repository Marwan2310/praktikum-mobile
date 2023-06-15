package id.ac.unpas.tokoelektronik.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.ac.unpas.tokoelektronik.R
import kotlinx.coroutines.launch

@Composable
fun AboutTeam() {
//    Column {
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = "Farriz Brilliant Wicaksana",fontSize = 18.sp,fontWeight = FontWeight.Bold)
//        Text(text = "Paiz Abdul Jabar", fontSize = 18.sp,fontWeight = FontWeight.Bold)
//        Text(text = "Marwan Hakim", fontSize = 18.sp,fontWeight = FontWeight.Bold)
//        Text(text = "Dika Sulaeman Akbar", fontSize = 18.sp,fontWeight = FontWeight.Bold)
//        Text(text = "Muhamad Rafliansyah", fontSize = 18.sp,fontWeight = FontWeight.Bold)
//    }
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val title = remember { mutableStateOf("") }
    val appBarHorizontalPadding = 4.dp
    val scrollState = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .verticalScroll(state = scrollState)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(10.dp)
                            ) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.faris),
                                    contentDescription = "Farriz",
                                    title = "Farriz Brilliant Wicaksana - 203040177"
                                )
                            }

                            Box(modifier = Modifier.padding(10.dp)) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.paiz),
                                    contentDescription = "Paiz",
                                    title = "Paiz Abdul Jabar - 203040108"
                                )
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(10.dp)
                            ) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.marwan),
                                    contentDescription = "Marwan ",
                                    title = "Marwan Hakim - 203040121"
                                )
                            }

                            Box(modifier = Modifier.padding(10.dp)) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.dika),
                                    contentDescription = "Dika",
                                    title = "Dika Sulaeman Akbar 203040163"
                                )
                            }

                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(10.dp)
                            ) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.rafli),
                                    contentDescription = "Rafli",
                                    title = "Muhamad Rafliansyah - 203040105"
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .padding(30.dp)
                                .fillMaxWidth()
                        ) {

                        }
                    }
                }