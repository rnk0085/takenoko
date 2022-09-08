package com.rnk0085.android.takenoko.domain.model

import java.util.*

/**
 * 個別の勉強記録
 */
data class StudyRecord(
    val studyTime: Long,
    val doneMessage: String, // できた！
    val createdAt: Date,
    val updatedAt: Date
)
