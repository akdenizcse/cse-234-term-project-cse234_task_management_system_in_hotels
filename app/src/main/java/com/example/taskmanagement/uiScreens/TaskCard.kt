package com.example.taskmanagement.uiScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.azureexp.utils.TaskData
import com.example.taskmanagement.getTasks.TaskViewModel


@Composable
fun TaskCard(task: TaskData, taskViewModel: TaskViewModel, navController: NavController) {

    var expanded by remember {
        mutableStateOf(false)
    }
    val backgroundColor = when (task.status) {
        0 -> Color.White// Not Started
        1 -> Color.Yellow // In Progress
        2 -> Color.Green // Done
        else -> Color.White
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        //change back to OutlinedCard based on the task card

        OutlinedCard(
            modifier = Modifier
                .width(150.dp)

                .padding(8.dp)
                .weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor
            ),
            elevation = CardDefaults.cardElevation(10.dp)


        ) {
            //change the background color of the card based on the task status
            Column(modifier = Modifier.padding(16.dp)) {


                Text(text = task.title, fontWeight = FontWeight.Bold)
                Text(text = task.description)
                TextButton(
                    onClick = { expanded = !expanded },


                    ) {
                    Text(
                        text = "Show options",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                if (expanded) {
                    Button(onClick = { taskViewModel.updateTaskStatus(task.id, 1) }) {
                        Text(text = "In Progress")
                    }
                    Button(onClick = { taskViewModel.updateTaskStatus(task.id, 2) }) {
                        Text(text = "Done")
                    }

                }


            }
        }

    }

}


