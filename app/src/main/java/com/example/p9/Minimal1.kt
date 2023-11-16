package com.example.p9

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

object Minimal1 {

    @Composable
    fun MinimalNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Marshroutes.route1) {
            composable(route = Marshroutes.route1) {Screen1(navController = navController) }
            composable(
                route = Marshroutes.route2 + "/{text}",
                arguments = listOf(
                    navArgument("text"){
                        type = NavType.StringType
                        defaultValue = "test"
                        nullable = true
                    })
            ) {Screen2(it.arguments?.getString("text")!!) }

            composable(route = Marshroutes.route3 + "?text={text}&number={number}",
                arguments = listOf(
                    navArgument("text") {
                        type = NavType.StringType
                        nullable = true
                    },
                    navArgument("number") {
                        type = NavType.IntType
                        defaultValue = 100
                    }) )
            {
                Screen3(
                    it.arguments?.getString("text"),
                    it.arguments?.getInt("number")
                )
            }
            composable(
                route = Marshroutes.route4 + "?text={text}",
                arguments = listOf(
                    navArgument("text") {
                        type = NavType.StringType
                        defaultValue = "test"
                        nullable = true
                    })
            ) {Screen4(it.arguments?.getString("text")!!) }
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Screen1(navController: NavController) {
        var text by remember {
            mutableStateOf("test")
        }
        OutlinedCard (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        )
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = text,
                    label = { Text(text = "what transfer to another screen:") },
                    onValueChange = {
                        text = it
                    }
                )

                Button(onClick = { navController.navigate(Marshroutes.route2 + "/$text") }) {
                    Text("Screen2")
                }

                Button(onClick = { navController.navigate(Marshroutes.route3 + "?text=$text&number=10")}){
                    Text("Screen3")
                }

                Button(onClick = { navController.navigate(Marshroutes.route4 + "?text=$text") }) {
                    Text("Screen4")
                }
            }
        }
    }

    @Composable
    fun Screen2(s: String?) {
        OutlinedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text("To Screen2 transfer this text:" + s)
        }
    }

    @Composable
    fun Screen3(s: String?, number: Int?) {
        OutlinedCard (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Text("To Screen3 transfer text and num: $s --- $number ---")
        }
    }

    @Composable
    fun Screen4(text: String?) {
        OutlinedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Text("To Screen4 transfer this text: $text")
        }
    }
}