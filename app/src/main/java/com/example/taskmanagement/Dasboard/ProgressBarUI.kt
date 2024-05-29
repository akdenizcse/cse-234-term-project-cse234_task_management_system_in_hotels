package com.example.taskmanagement.Dasboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.azureexp.ui.theme.Poppins
import com.example.azureexp.ui.theme.PrimaryColor
import com.example.azureexp.ui.theme.PrimaryTextColor
import com.example.azureexp.ui.theme.SecondaryColor
import com.example.azureexp.ui.theme.SubTextColor

@Composable
fun ProgressBarUI(percentage: Float) {
    Box(
        modifier = Modifier.size(120.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(100.dp)
                .padding(6.dp)
        ) {
            drawCircle(
                SolidColor(Color(0xFFE3E5E7)),
                size.width / 2,
                style = Stroke(26f)
            )
            val convertedValue = (percentage / 100) * 360
            drawArc(
                brush = Brush.linearGradient(
                    colors = listOf(SecondaryColor, PrimaryColor)
                ),
                startAngle = -90f,
                sweepAngle = convertedValue,
                useCenter = false,
                style = Stroke(26f, cap = StrokeCap.Round)
            )
        }

        val annotatedString2 = AnnotatedString.Builder("${percentage.toInt()}%\nDone")
            .apply {
                addStyle(
                    SpanStyle(
                        color = SubTextColor,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Normal
                    ), 4, 8
                )
            }

        Text(
            text = annotatedString2.toAnnotatedString(),
            fontFamily = Poppins,
            fontSize = 14.sp,
            color = PrimaryTextColor,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
