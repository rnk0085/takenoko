package com.rnk0085.android.takenoko.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rnk0085.android.takenoko.data.dao.StudyDao
import com.rnk0085.android.takenoko.data.entity.StudyEntity
import com.rnk0085.android.takenoko.utils.DateConverters

@Database(
    entities = [StudyEntity::class],
    version = 1
)
@TypeConverters(DateConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studyDao(): StudyDao
}
