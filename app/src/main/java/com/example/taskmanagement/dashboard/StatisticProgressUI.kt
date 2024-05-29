package com.example.taskmanagement.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagement.R
import com.example.taskmanagement.ui.theme.Poppins
import com.example.taskmanagement.ui.theme.PrimaryColor
import com.example.taskmanagement.ui.theme.PrimaryTextColor
import com.example.taskmanagement.ui.theme.SecondaryColor
import com.example.taskmanagement.ui.theme.SubTextColor

@Composable
fun StatisticProgressUI(primaryPercentage: Float = 60f, secondaryPercentage: Float = 15f) {
    Box(
        modifier = Modifier
            .size(120.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(100.dp)
        ) {
            drawCircle(
                SolidColor(Color(0xFFE3E5E7)),
                size.width / 2,
                style = Stroke(34f)
            )
            val convertedPrimaryValue = (primaryPercentage / 100) * 360
            val convertedSecondaryValue = ((secondaryPercentage / 100) * 360) + convertedPrimaryValue
            drawArc(
                brush = SolidColor(SecondaryColor),
                startAngle = -90f,
                sweepAngle = convertedSecondaryValue,
                useCenter = false,
                style = Stroke(34f, cap = StrokeCap.Round)
            )
            drawArc(
                brush = SolidColor(PrimaryColor),
                startAngle = -90f,
                sweepAngle = convertedPrimaryValue,
                useCenter = false,
                style = Stroke(34f, cap = StrokeCap.Round)
            )
        }

        val annotatedString2 = AnnotatedString.Builder("${(primaryPercentage + secondaryPercentage).toInt()}%\nDone")
            .apply {
                addStyle(
                    SpanStyle(
                        color = SubTextColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal
                    ), 4, 8
                )
            }

        Text(
            text = annotatedString2.toAnnotatedString(),
            fontFamily = Poppins,
            fontSize = 20.sp,
            color = PrimaryTextColor,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun StatisticIndicatorUI() {
    Column(
        modifier = Modifier
            .height(120.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        IndicatorItemUI(text = "Todo")
        IndicatorItemUI(color = SecondaryColor, text = "Done")
        IndicatorItemUI(color = Color(0xFFE3E5E7), text = "In progress")
    }
}

@Composable
fun IndicatorItemUI(color: Color = PrimaryColor, text: String) {
    Row {
        Icon(
            painter = painterResource(id = R.drawable.ic_circle),
            contentDescription = "",
            tint = color,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontFamily = Poppins,
            fontSize = 12.sp,
            color = Color(0xFF818181),
            fontWeight = FontWeight.Normal
        )
    }
}
