package com.hadi.headlinescompose.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hadi.headlinescompose.R

// Set of Material typography styles to start with

val RockWell = FontFamily(
    Font(R.font.rockwell_std_regular),
    Font(R.font.rockwell_std_bold, FontWeight.Bold)
)

val Calisto = FontFamily(
    Font(R.font.calisto_mt_std),
)


val Typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 96.sp,
    )
)