package com.example.utils.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val invertTextColor: Color,
    val increaseTextColor: Color,
    val decreaseTextColor: Color
)

val lightPalette = Colors(
    primaryBackground = Color.White,
    secondaryBackground = Color(0xFFF0F4F7),
    primaryTextColor = Color(0xFF1A1A1A),
    secondaryTextColor = Color(0xFFBABABA),
    invertTextColor = Color.White,
    increaseTextColor = Color(0xFF24B25D),
    decreaseTextColor = Color(0xFFB22424),
)

val darkPalette = Colors(
    primaryBackground = Color.White,
    secondaryBackground = Color(0xFFF0F4F7),
    primaryTextColor = Color(0xFF1A1A1A),
    secondaryTextColor = Color(0xFFBABABA),
    invertTextColor = Color.White,
    increaseTextColor = Color(0xFF24B25D),
    decreaseTextColor = Color(0xFFB22424),
)