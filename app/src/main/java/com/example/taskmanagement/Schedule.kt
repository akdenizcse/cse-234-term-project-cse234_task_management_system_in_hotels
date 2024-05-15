package com.example.taskmanagement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.jetbrains.annotations.Async.Schedule

@Composable
fun Schedule(navController: NavController) {
    val tasks = listOf(
        Task(1,"lorem","lorem ipsulum",Status.InProgress),
        Task(2,"lorem","lorem ipsulum",Status.InProgress),
        Task(3,"lorem","lorem ipsulum",Status.Todo)


    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "To do Tasks",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,


            )
        Spacer(modifier = Modifier.height(10.dp))
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
        Column {

            for (task in tasks) {
                if (task.status == Status.Todo){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedCard(
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = task.title, fontWeight = FontWeight.Bold)
                                Text(text = task.description)
                            }
                        }
                        Button(
                            onClick = { task.status = Status.InProgress },
                            modifier = Modifier.align(Alignment.CenterVertically)
                        ) {
                            Text(text = "make inprogress")
                        }
                    }
                }}
        }
    }
}