package com.example.search.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.search.R
import com.example.utils.ui.theme.AppTheme

@Composable
@Preview
fun SearchBar() {
    val state = remember { mutableStateOf("") }
    Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)) {
        TextField(
            value = state.value, onValueChange = { value ->
                state.value = value
            },
            placeholder = {
                Text(
                    text = "Find company or ticker",
                    fontSize = 20.sp,
                    color = AppTheme.colors.primaryTextColor
                )
            },
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(40.dp))
                .fillMaxWidth(),
            maxLines = 1,
            shape = RoundedCornerShape(40.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Image(
                    painter = painterResource(
                        if (state.value.isEmpty())
                            R.drawable.search_icon
                        else
                            R.drawable.back_icon
                    ),
                    contentDescription = null
                )
            },
            trailingIcon = {
                if (state.value.isNotEmpty())
                    IconButton(
                        onClick = {
                            state.value = ""
                        },
                        enabled = true
                    ) {
                        Image(
                            painter = painterResource(R.drawable.clear_icon),
                            contentDescription = null,
                        )
                    }
            }
        )
    }
}
