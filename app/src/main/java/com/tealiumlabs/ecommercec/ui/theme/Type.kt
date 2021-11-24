package com.tealiumlabs.ecommercec.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tealiumlabs.ecommercec.R

private val WorkSans = FontFamily(
    Font(R.font.work_sans_regular, FontWeight.Normal),
    Font(R.font.work_sans_medium, FontWeight.Medium),
    Font(R.font.work_sans_semibold, FontWeight.SemiBold),
    Font(R.font.work_sans_bold, FontWeight.Bold),
)

private val Robots = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val EcommTypography = Typography(
    body1 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    body2 = TextStyle(
        fontFamily = WorkSans
    ),
    subtitle1 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 20.sp,
    ),
    button = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.SemiBold
    ),
    h4 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp,
    ),
    h5 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 18.sp,
    ),
    h6 = TextStyle(
        fontFamily = Robots,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),
    caption = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
    )
)