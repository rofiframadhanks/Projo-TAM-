package com.example.projo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projo.ui.theme.ProjoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjoTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun FilledButtonExample1(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("TASK")
    }
}

@Composable
fun FilledButtonExample2(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("IN-PROGRESS")
    }
}

@Composable
fun FilledButtonExample3(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("COMPLETE")
    }
}

@Composable
fun FilledButtonExample4(context: Context, onClick: () -> Unit) {
    Button(onClick = {
        val intent = Intent(context, CreateActivity::class.java)
        context.startActivity(intent)
    }) {
        Text("+")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .fillMaxHeight()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(Color.LightGray)
        ) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "PROJO", fontSize = 20.sp, textAlign = TextAlign.Start)
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color.Transparent), contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Manage Your Work Here", fontSize = 25.sp, textAlign = TextAlign.Center)
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(25.dp)
                .height(120.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.complete),
                    contentDescription = null,
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .padding(end = 60.dp, start = 30.dp)
                        .width(100.dp),
                    contentScale = ContentScale.FillWidth
                )

                FilledButtonExample1(onClick = { /* Action when button is clicked */ })
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(25.dp)
                .height(120.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.progress),
                    contentDescription = null,
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .padding(end = 40.dp, start = 30.dp)
                        .width(100.dp),
                    contentScale = ContentScale.FillWidth
                )

                FilledButtonExample2(onClick = { /* Action when button is clicked */ })
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(25.dp)
                .height(120.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.complete),
                    contentDescription = null,
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .padding(end = 50.dp, start = 30.dp)
                        .width(100.dp),
                    contentScale = ContentScale.FillWidth
                )

                FilledButtonExample3(onClick = { /* Action when button is clicked */ })
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(25.dp)
                .height(120.dp)
                .background(Color.Transparent),
            contentAlignment = Alignment.BottomEnd
        ) {
            FilledButtonExample4(context = context, onClick = { /* Action when button is clicked */ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjoTheme {
        Greeting("Android")
    }
}
