package com.rnk0085.android.takenoko.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.R
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun PraiseSection(
    praiseMessage: String,
    screenWidth: Dp,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // TODO: 定数で定義する
        Text(
            text = praiseMessage,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )

        TakenokoCharacterImage(
            screenWidth = screenWidth,
            painter = painter
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopPraiseSectionPreview() {
    TakenokoTheme {
        PraiseSection(
            praiseMessage = "3日連続だね！\nすごい！！！",
            screenWidth = 360.dp,
            painter = painterResource(id = R.drawable.character2)
        )
    }
}
