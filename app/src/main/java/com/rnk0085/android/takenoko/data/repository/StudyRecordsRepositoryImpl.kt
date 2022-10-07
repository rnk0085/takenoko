package com.rnk0085.android.takenoko.data.repository

import com.rnk0085.android.takenoko.data.dao.StudyDao
import com.rnk0085.android.takenoko.data.entity.StudyEntity
import java.util.*
import javax.inject.Inject

class StudyRecordsRepositoryImpl @Inject constructor(
    private val studyDao: StudyDao
) : StudyRecordsRepository {
    override suspend fun insertStudyRecords(studyTime: Long, doneMessage: String) {
        val date = Date()

        val studyEntity = StudyEntity(
            studyTime = studyTime,
            doneMessage = doneMessage,
            createdAt = date,
            updatedAt = date
        )

        studyDao.insert(studyEntity)
    }
}
