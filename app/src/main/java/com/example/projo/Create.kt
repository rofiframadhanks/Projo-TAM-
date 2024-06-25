package com.example.projo

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projo.ui.theme.ProjoTheme
//
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.projo.ui.theme.ProjoTheme

class CreateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjoTheme {
                CreateUI()
            }
        }
    }
}

// Define the colors to match the image
private val LightBlue = Color(0xFF007AFF)
private val BackgroundColor = Color(0xFFEAF0F8)
private val DarkBlue = Color(0xFF002366)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUI() {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var deadline by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("To-Do") }
    var expanded by remember { mutableStateOf(false) }

    val statusOptions = listOf("To-do", "In-progress", "Completed")

    Column(
        modifier = Modifier
            .background(BackgroundColor)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Projo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue
            )
            IconButton(onClick = { /* buat apus */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_delete),
                    contentDescription = "Delete",
                    tint = LightBlue
                )
            }
        }

        Text(
            text = "Create a New Task",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Text(text = "Title", fontSize = 16.sp, color = Color(0xFF6B7280), modifier = Modifier.padding(bottom = 4.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = DarkBlue, fontWeight = FontWeight.Bold),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent
                )
            )
        }

        Text(text = "Description", fontSize = 16.sp, color = Color(0xFF6B7280), modifier = Modifier.padding(bottom = 4.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = DarkBlue, fontWeight = FontWeight.Bold),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent
                ),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu_edit),
                        contentDescription = null,
                        tint = LightBlue
                    )
                }
            )
        }

        Text(text = "Deadline", fontSize = 16.sp, color = Color(0xFF6B7280), modifier = Modifier.padding(bottom = 4.dp))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 16.dp)) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                TextField(
                    value = deadline,
                    onValueChange = { deadline = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = DarkBlue, fontWeight = FontWeight.Bold),
                    colors = TextFieldDefaults.textFieldColors(
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        containerColor = Color.Transparent
                    )
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_today),
                contentDescription = null,
                tint = LightBlue,
                modifier = Modifier.size(56.dp)
            )
        }

        Text(text = "Task Status", fontSize = 16.sp, color = Color(0xFF6B7280), modifier = Modifier.padding(bottom = 4.dp))

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                TextField(
                    value = status,
                    onValueChange = { },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    statusOptions.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(selectionOption) },
                            onClick = {
                                status = selectionOption
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        // Create Button
        Button(
            onClick = { /* handle create action */ },
            colors = ButtonDefaults.buttonColors(containerColor = LightBlue),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .shadow(8.dp, RoundedCornerShape(8.dp))
        ) {
            Text(text = "CREATE", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreatePreview() {
    ProjoTheme {
        CreateUI()
    }
}
