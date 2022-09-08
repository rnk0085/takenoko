package com.rnk0085.android.takenoko.ui.screen.top

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.android.takenoko.domain.model.StudyRecord
import com.rnk0085.android.takenoko.ui.theme.TakenokoTheme
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DoneListTile(
    studyRecord: StudyRecord,
    modifier: Modifier = Modifier
) {
    val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd(E)")

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = modifier.padding(8.dp)
        ) {
            Text(
                text = studyRecord.doneMessage,
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = simpleDateFormat.format(studyRecord.updatedAt),
                color = Color.Gray,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview
@Composable
private fun DoneListTilePreview() {
    TakenokoTheme {
        DoneListTile(
            studyRecord = StudyRecord(
                studyTime = 500,
                doneMessage = "1時間作業した！",
                createdAt = Date(1662800000000),
                updatedAt = Date(1662800000000)
            )
        )
    }
}
