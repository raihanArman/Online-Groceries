package com.randev.online_groceries

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.randev.online_groceries.navigation.SetupNavGraph
import com.randev.online_groceries.ui.theme.OnlineGroceriesTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineGroceriesTheme {
                navHostController = rememberNavController()
                SetupNavGraph(navController = navHostController)
            }
        }
    }
}