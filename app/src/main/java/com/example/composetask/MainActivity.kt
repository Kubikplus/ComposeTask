package com.example.composetask

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import com.example.composetask.ui.theme.ComposeTaskTheme
import com.example.composetask.ui.theme.components.BottomButtons
import com.example.composetask.ui.theme.components.CustomAppBar
import com.example.composetask.ui.theme.navigation.Navigation
import com.example.composetask.ui.theme.view.MainPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTaskTheme {
                // A surface container using the 'background' color from the theme
               Navigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTaskTheme {
        Greeting("Android")
    }
}