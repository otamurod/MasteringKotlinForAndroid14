package uz.otamurod.chapter04.materialcomponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PacktFloatingActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        content = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "New Chat"
            )
        }
    )
}

@Preview
@Composable
fun PacktFloatingActionButtonPreview() {
    PacktFloatingActionButton()
}