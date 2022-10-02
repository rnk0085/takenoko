package com.rnk0085.android.takenoko.di

import com.rnk0085.android.takenoko.data.repository.StudyRecordsRepository
import com.rnk0085.android.takenoko.data.repository.StudyRecordsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindStudyRecordsRepository(
        studyRecordsRepositoryImpl: StudyRecordsRepositoryImpl
    ) : StudyRecordsRepository
}
