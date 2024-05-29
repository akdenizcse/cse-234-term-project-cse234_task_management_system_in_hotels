package com.example.taskmanagement.Dasboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.azureexp.ui.theme.Poppins
import com.example.azureexp.R
import com.example.azureexp.ui.theme.PrimaryTextColor
import com.example.azureexp.ui.theme.Shapes
import com.example.azureexp.ui.theme.SubTextColor
import com.example.taskmanagement.R
import com.example.taskmanagement.ui.theme.Poppins
import com.example.taskmanagement.ui.theme.PrimaryTextColor

@Composable
fun StatisticUI() {
    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        Text(
            //task eklicez
            text = "Jetpack Compose UI Design",
            fontFamily = Poppins,
            fontSize = 16.sp,
            color = PrimaryTextColor,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "",
                    tint = Color(0xFF818181),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "09.00 AM - 11.00 AM",
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    color = Color(0xFF818181),
                    fontWeight = FontWeight.Medium
                )
            }
            Box(
                modifier = Modifier
                    .clip(Shapes.large)
                    .background(Color(0xFFE1E3FA))
                    .border(width = 0.dp, color = Color.Transparent, shape = Shapes.large)
                    .padding(horizontal = 10.dp, vertical = 2.dp),
            ) {
                Text(
                    text = "On Going",
                    fontSize = 10.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF7885B9)
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Statistic",
            fontFamily = Poppins,
            fontSize = 16.sp,
            color = SubTextColor,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            StatisticProgressUI()
            Spacer(modifier = Modifier.width(12.dp))
            StatisticIndicatorUI()
        }
    }
}