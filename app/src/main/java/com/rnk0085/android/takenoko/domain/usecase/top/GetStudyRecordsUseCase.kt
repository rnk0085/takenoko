package com.rnk0085.android.takenoko.domain.usecase.top

import com.rnk0085.android.takenoko.domain.model.StudyRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class GetStudyRecordsUseCase @Inject constructor() {
    operator fun invoke(): Flow<List<StudyRecord>> = flow {
        // TODO: DBから取ってくる
        // 最新記録の順
        // デフォルトは「○○時間○○分作業した！」の想定
        emit(
            listOf(
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "読書した！",
                    createdAt = Date(1662800000000),
                    updatedAt = Date(1662800000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "プログラミングした！",
                    createdAt = Date(1662800000000),
                    updatedAt = Date(1662800000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "1時間作業した！",
                    createdAt = Date(1662800000000),
                    updatedAt = Date(1662800000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "30分作業した！",
                    createdAt = Date(1662800000000),
                    updatedAt = Date(1662800000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "資料を作成した！",
                    createdAt = Date(1662800000000),
                    updatedAt = Date(1662800000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "プログラミングした！",
                    createdAt = Date(1662800000000),
                    updatedAt = Date(1662800000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "今日の計画を立てた！",
                    createdAt = Date(1662800000000),
                    updatedAt = Date(1662800000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "課題に取り組んだ！",
                    createdAt = Date(1662700000000),
                    updatedAt = Date(1662700000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "30分作業した！",
                    createdAt = Date(1662700000000),
                    updatedAt = Date(1662700000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "10分作業した！",
                    createdAt = Date(1662700000000),
                    updatedAt = Date(1662700000000)
                ),
                StudyRecord(
                    studyTime = 500,
                    doneMessage = "今日の計画を立てた！",
                    createdAt = Date(1662700000000),
                    updatedAt = Date(1662700000000)
                ),
            )
        )
    }
}
