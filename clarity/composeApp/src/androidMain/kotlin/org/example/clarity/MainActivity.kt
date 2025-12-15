package org.example.clarity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import org.example.clarity.screens.InputScreen
import org.example.clarity.screens.LoginScreen
import org.example.clarity.screens.NotesScreen
import org.example.clarity.screens.RegisterScreen
import org.example.clarity.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme(darkTheme = true) {
                Scaffold { paddingValues ->
//                    RegisterScreen(modifier = Modifier.padding(paddingValues))
//                    LoginScreen(modifier = Modifier.padding(paddingValues))
//                    NotesScreen(modifier = Modifier.padding(paddingValues))
                    InputScreen(modifier = Modifier.padding(paddingValues))
                }

            }

        }
    }
}
