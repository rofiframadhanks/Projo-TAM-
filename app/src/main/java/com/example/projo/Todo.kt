package com.example.projo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projo.ui.theme.ProjoTheme

data class Task(
    val title: String,
    val description: String,
    val deadline: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
class TodoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjoTheme {
                TodoUI()
            }
        }
    }
}

@Composable
fun TodoUI() {
    val tasks = remember { mutableStateListOf(
        Task("Uas TAM", "Description of Uas TAM", "2024-06-25 12:00", "To-Do")
        // Add more tasks here
    )}

    Column(
        modifier = Modifier
            .background(Color(0xFFEAF0F8))
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Projo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF002366),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        for (task in tasks) {
            TaskCard(task)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TaskCard(task: Task) {
    Box(
        modifier = Modifier
            .background(Color(0xFFDDE2F4), RoundedCornerShape(10.dp))
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                // Handle task click
            }
    ) {
        Column {
            Text(
                text = task.title,
                color = Color(0xFF8377D1),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = task.description,
                color = Color(0xFF3440FF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = task.deadline,
                color = Color(0xFF3440FF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = task.status,
                color = Color(0xFF3440FF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoPreview() {
    ProjoTheme {
        TodoUI()
    }
}
