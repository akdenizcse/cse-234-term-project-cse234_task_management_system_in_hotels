package com.example.taskmanagement.dashboard

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.taskmanagement.R
import com.example.taskmanagement.ui.theme.Poppins
import com.example.taskmanagement.ui.theme.PrimaryColor
import com.example.taskmanagement.ui.theme.PrimaryTextColor
import com.example.taskmanagement.ui.theme.Shapes
import com.example.taskmanagement.ui.theme.SubTextColor


@Composable
fun TaskCardUI(navController: NavController) {
    val annotatedString1 = AnnotatedString.Builder("4/6 Task").apply {
            addStyle(
                SpanStyle(
                    color = PrimaryColor,
                ), 0, 3
            )
        }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp)
            .padding(top = 40.dp),
        shape = Shapes.large
    ) {
        Row(
            modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Tasks",
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = SubTextColor,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_tick_circle),
                        contentDescription = "",
                        tint = PrimaryColor,
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = annotatedString1.toAnnotatedString(),
                        fontFamily = Poppins,
                        fontSize = 18.sp,
                        color = PrimaryTextColor,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Almost finished,\nkeep it up",
                    fontFamily = Poppins,
                    fontSize = 13.sp,
                    color = Color(0xFF292D32),
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { navController.navigate("inprogressTasks") },
                    modifier = Modifier
                        .clip(Shapes.large)
                        .border(width = 0.dp, color = Color.Transparent, shape = Shapes.large),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                    contentPadding = PaddingValues(vertical = 0.dp, horizontal = 16.dp)
                ) {
                    Text(
                        text = "Daily Task",
                        fontSize = 10.sp,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),
                        fontFamily = Poppins
                    )
                }
            }
            ProgressBarUI(percentage = 67f)
        }
    }
}