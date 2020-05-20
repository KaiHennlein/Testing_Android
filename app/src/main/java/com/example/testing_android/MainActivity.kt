package com.example.testing_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.TextField
import androidx.ui.foundation.TextFieldValue
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainContend(MainContendState())
            }
        }
    }
}
@Model
class MainContendState(var text: String = "Please Enter your name", var output: String = "")
@Composable
fun MainContend(mainContendState: MainContendState) {
    Scaffold(
        topAppBar = {
          TopAppBar(title = {Text(text = "Basic Interaction")})
        },
        bodyContent = {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp)

            ) {
                TextField(value = TextFieldValue(mainContendState.text),
                    onValueChange = {mainContendState.text = it.text})
                Button(onClick = {
                    mainContendState.output = mainContendState.text.toUpperCase()
                }) {
                    Text("Save")
                }
                Text(text = mainContendState.output)
                Text(text = "Hello World!")
            }
        }
    )

}





@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        MainContend(MainContendState())
    }
}