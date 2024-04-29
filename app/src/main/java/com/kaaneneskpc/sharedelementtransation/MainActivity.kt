package com.kaaneneskpc.sharedelementtransation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.kaaneneskpc.sharedelementtransation.navigation.SetupNavGraph
import com.kaaneneskpc.sharedelementtransation.ui.theme.SharedElementTransationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedElementTransationTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}