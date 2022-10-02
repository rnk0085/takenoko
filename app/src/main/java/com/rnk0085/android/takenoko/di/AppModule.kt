package com.rnk0085.android.takenoko.di

import android.content.Context
import androidx.room.Room
import com.rnk0085.android.takenoko.data.AppDatabase
import com.rnk0085.android.takenoko.data.dao.StudyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// https://stackoverflow.com/questions/63146318/how-to-create-and-use-a-room-database-in-kotlin-dagger-hilt
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_database"
    ).build()

    @Singleton
    @Provides
    fun provideStudyDao(
        database: AppDatabase
    ): StudyDao = database.studyDao()
}
