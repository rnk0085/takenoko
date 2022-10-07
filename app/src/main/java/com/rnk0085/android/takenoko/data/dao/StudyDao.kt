package com.rnk0085.android.takenoko.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.rnk0085.android.takenoko.data.entity.StudyEntity

@Dao
interface StudyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(studyEntity: StudyEntity)
}
