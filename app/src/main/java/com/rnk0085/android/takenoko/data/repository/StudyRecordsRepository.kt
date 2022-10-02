package com.rnk0085.android.takenoko.data.repository

// TODO: もしかしたら、Domain層に置いた方が良いかも？
interface StudyRecordsRepository {
    suspend fun insertStudyRecords(
        studyTime: Long,
        doneMessage: String
    )
}
