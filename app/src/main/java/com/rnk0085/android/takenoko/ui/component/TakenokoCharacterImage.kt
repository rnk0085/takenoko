package com.rnk0085.android.takenoko.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.R
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun TakenokoCharacterImage(
    screenWidth: Dp,
    painter: Painter,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
) {
    // TODO: 「3」の部分を外部で定義する
    val imageWidth = screenWidth / 3
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier.width(imageWidth)
    )
}

@Preview
@Composable
fun TakenokoCharacterImagePreview() {
    TakenokoTheme {
        TakenokoCharacterImage(
            screenWidth = 200.dp,
            painter = painterResource(id = R.drawable.character2)
        )
    }
}
