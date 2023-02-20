package com.example.utils.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.core.data.Snippet
import com.example.utils.ui.theme.AppTheme

@Composable
fun SnippetItem(
    snippet: Snippet,
    lightBackground: Boolean = true,
    onStartClicked: (Snippet) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
            .background(
                if (lightBackground) AppTheme.colors.primaryBackground else AppTheme.colors.secondaryBackground,
                shape = AppTheme.shapes.medium
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(snippet.logoUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .size(52.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp, vertical = 8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = snippet.ticketName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Box(modifier = Modifier
                    .padding(6.dp)
                    .clip(RoundedCornerShape(60))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = true)
                    ) {
                        onStartClicked.invoke(snippet)
                    }
                ) {
                    Image(
                        painter = painterResource(if (snippet.isFavorite) R.drawable.icon_saved else R.drawable.icon_not_saved),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(6.dp)
                    )
                }


            }
            Text(text = snippet.companyName, color = AppTheme.colors.primaryTextColor)
        }

        Column(modifier = Modifier.padding(end = 12.dp)) {
            Text(
                text = snippet.currentPrice,
                modifier = Modifier.align(Alignment.End),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = AppTheme.colors.primaryTextColor
            )

            Text(
                text = snippet.dailyChange,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = when {
                    snippet.dailyChangeRaw > 0 -> AppTheme.colors.increaseTextColor
                    snippet.dailyChangeRaw < 0 -> AppTheme.colors.decreaseTextColor
                    else -> AppTheme.colors.primaryTextColor
                }
            )
        }
    }
}

//@Composable
//@Preview
//private fun PreviewView() {
//    val snippetTest = Snippet(
//        ticketName = "YNDX",
//        companyName = "Yandex, LLC",
//        currency = "RUB",
//        currentPrice = "4 764,6",
//        dailyChange = "+55 (+1,15%)",
//        dailyChangeRaw = 55f,
//        isFavorite = true,
//        logoUrl = "https://avatars.mds.yandex.net/get-lpc/1370085/46f1ad12-1fea-4c68-abb0-f0ddc7c93480/width_1280x2"
//    )
//
//    SnippetItem(snippet = snippetTest, )
//}