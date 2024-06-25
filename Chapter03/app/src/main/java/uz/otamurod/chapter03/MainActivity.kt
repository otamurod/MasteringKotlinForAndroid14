package uz.otamurod.chapter03

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.chapter03.ui.theme.Chapter03Theme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            Chapter03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val context = LocalContext.current

                    MyApp(onCountReached = {
                        val intent = Intent(context, SecondActivity::class.java)
                        startActivity(intent)
                    },
                        onVerticalItemClick = {
                            val intent = Intent(context, ThirdActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(
    onCountReached: () -> Unit,
    onVerticalItemClick: () -> Unit,
) {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Counter: $count", style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                count++
                if (count == 5) {
                    count = 0
                    onCountReached()
                }
            }) {
                Text("Increment")
            }
        }

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.LightGray)
                .padding(8.dp),
            columns = GridCells.Fixed(3)
        ) {
            items(100) {
                Text(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            onVerticalItemClick()
                        },
                    text = "Item number $it"
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        LazyHorizontalGrid(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.LightGray)
                .padding(8.dp),
            rows = GridCells.Fixed(5)
        ) {
            items(100) {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Item number $it"
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Chapter03Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
            MyApp({}, {})
        }
    }
}