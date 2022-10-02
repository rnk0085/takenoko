package com.rnk0085.android.takenoko.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rnk0085.android.takenoko.data.dao.StudyDao
import com.rnk0085.android.takenoko.data.entity.StudyEntity

@Database(
    entities = [StudyEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studyDao(): StudyDao
}
