package org.example.clarity.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.clarity.components.MainInputField

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        // Top Background Section (same as Login)
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.50f)

        ) {}

        // Content Section
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,

            )

            MainInputField(
                value = username,
                onValueChange = { username = it },
                label = "Username",
                keyBoardType = KeyboardType.Text,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            MainInputField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                keyBoardType = KeyboardType.Email,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            MainInputField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                keyBoardType = KeyboardType.Password,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { /* handle register click */ },
                modifier = Modifier
                    .width(120.dp)
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Register")
            }


            TextButton(onClick = { /* navigate back to login */ }) {
                Text(
                    "Already have an account? Login",
                    fontSize = 15.sp,
                )
            }
        }
    }
}

