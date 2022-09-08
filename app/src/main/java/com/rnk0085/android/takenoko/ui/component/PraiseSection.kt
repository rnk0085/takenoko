package com.rnk0085.android.takenoko.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rnk0085.android.takenoko.R
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme

@Composable
fun PraiseSection(
    praiseMessage: String,
    screenWidth: Dp,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // TODO: 定数で定義する
        Text(
            text = praiseMessage,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(18.dp)
                .weight(2f),
            fontSize = 32.sp
        )

        TakenokoCharacterImage(
            screenWidth = screenWidth,
            painter = painterResource(id = R.drawable.character2),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopPraiseSectionPreview() {
    TakenokoTheme {
        PraiseSection(
            praiseMessage = "3日連続だね！すごい！！！",
            screenWidth = 360.dp
        )
    }
}
