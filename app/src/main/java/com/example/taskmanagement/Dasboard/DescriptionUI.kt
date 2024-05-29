package com.example.taskmanagement.Dasboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.azureexp.ui.theme.Poppins
import com.example.azureexp.ui.theme.SubTextColor


    @Composable
    fun DescriptionUI() {
        Column(
            modifier = Modifier.padding(horizontal = 30.dp)
        ) {
            Text(
                text = "Description",
                fontFamily = Poppins,
                fontSize = 16.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Make a mobile app to show tasks  " +
                        "-------------------------------- " +
                        "also create thumbnail and other pages",
                fontFamily = Poppins,
                fontSize = 11.sp,
                color = SubTextColor,
                fontWeight = FontWeight.Normal
            )
        }
    }
