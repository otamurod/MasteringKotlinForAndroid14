package uz.otamurod.chapter04.materialcomponents

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.chapter04.ui.theme.Chapter04Theme

@Composable
fun AppContent() {
    Scaffold(
        topBar = {
            PacktSmallTopAppBar()
        },
        bottomBar = {
            PacktBottomNavigationBar()
        },
        floatingActionButton = {
            PacktFloatingActionButton()
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.Gray.copy(alpha = 0.1f)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "Mastering Kotlin for Android Development - Chapter 4",
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppContentPreview() {
    Chapter04Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AppContent()
        }
    }
}