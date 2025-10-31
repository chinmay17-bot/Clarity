package org.example.clarity.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import org.example.clarity.utils.OnPrimaryColor

@Composable
fun MainInputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyBoardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true,
    textColor: Color = Color.Black,
    labelColor: Color = Color.Gray
) {
    // Implementation of the MainInputField component
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = OnPrimaryColor) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyBoardType),
        modifier = Modifier.fillMaxWidth()
    )
}