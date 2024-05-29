package com.example.taskmanagement.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.taskmanagement.R
import com.example.taskmanagement.ui.theme.Poppins
import com.example.taskmanagement.ui.theme.PrimaryTextColor
import com.example.taskmanagement.ui.theme.SubTextColor

@Composable
fun HeaderUI(firstName: String,secondName: String,department: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hello,$firstName $secondName",
                fontFamily = Poppins,
                fontSize = 18.sp,
                color = PrimaryTextColor,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = department,
                fontFamily = Poppins,
                fontSize = 14.sp,
                color = SubTextColor,
                fontWeight = FontWeight.Medium
            )
        }

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
        )
    }
}