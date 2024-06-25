package uz.otamurod.chapter03

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import uz.otamurod.chapter03.ui.theme.Chapter03Theme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Chapter03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowConstraintLayout(
                        onIconClick = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ShowConstraintLayout(
    onIconClick: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
    ) {
        val (icon, text) = createRefs()
        Icon(
            modifier = Modifier
                .size(80.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .clickable { onIconClick() },
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.Green
        )

        Text(
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(icon.end)
                },
            text = "9",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutPreview() {
    Chapter03Theme {
        ShowConstraintLayout({})
    }
}