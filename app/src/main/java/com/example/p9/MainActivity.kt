package com.example.p9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.p9.ui.theme.P9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Minimal1.MinimalNavigation()
            //P9Theme {
               // Surface (
                 //   modifier = Modifier.fillMaxSize(),
                   // color = MaterialTheme.colorScheme.background
                //) {
                    //Minimal0.MinimalNavigation()
                //}
            //}
        }
    }
}
