package com.rnk0085.android.takenoko.utils

import androidx.room.TypeConverter
import java.util.*

// https://developer.android.com/training/data-storage/room/referencing-data#type-converters
class DateConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
