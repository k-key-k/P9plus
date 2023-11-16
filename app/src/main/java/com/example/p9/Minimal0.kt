package com.example.p9

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation


object Minimal0 {
    @Composable
    fun MinimalNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Marshroutes.route1) {
            composable(route = Marshroutes.route1) {
                Screen1(navController = navController)
            }
            composable(route = Marshroutes.route2) {
                Screen2()
            }
            composable(route = Marshroutes.route3) {
                Screen3()
            }
            composable(route = Marshroutes.route4) {
                Screen4()
            }
        }
    }

    @Composable
    fun Screen1(navController: NavController) {
        OutlinedCard (modifier = Modifier
            .fillMaxSize()
            .padding(20.dp))
        {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Button(onClick = { navController.navigate(Marshroutes.route2) }) {
                    Text(text = "Экран2")
                }
                Button(onClick = { navController.navigate(Marshroutes.route3) }) {
                    Text(text = "Экран3")
                }
                Button(onClick = { navController.navigate(Marshroutes.route4) }) {
                    Text(text = "Экран4")
                }
            }
        }
    }

    @Composable
    fun Screen2() {
        OutlinedCard (modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
            Text("Экран2")
        }
    }

    @Composable
    fun Screen3() {
        OutlinedCard (modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
            Text("Экран3")
        }
    }

    @Composable
    fun Screen4() {
        OutlinedCard (modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
            Text("Экран4")
        }
    }
}