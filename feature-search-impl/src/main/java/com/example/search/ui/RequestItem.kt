package com.example.search.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utils.ui.theme.AppTheme

@Composable
@Preview
fun RequestItem() {
    Card(
        modifier = Modifier.padding(2.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = AppTheme.colors.secondaryBackground
    ) {
        Text(
            text = "Apple",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        )
    }
}