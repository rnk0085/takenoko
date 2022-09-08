package com.rnk0085.android.takenoko.domain.usecase.home

import com.rnk0085.android.takenoko.domain.model.DayRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class GetDayRecordsUseCase @Inject constructor() {
    operator fun invoke(): Flow<List<DayRecord>> = flow {
        // TODO: DBから取ってくる
        emit(
            // とりあえずそれっぽいデータを用意
            listOf(
                DayRecord(
                    totalStudyTime = 3000,
                    date = Date(1661110000000) // 2022/08/21
                ),
                DayRecord(
                    totalStudyTime = 4000,
                    date = Date(1661160000000) // 2022/08/22
                ),
                DayRecord(
                    totalStudyTime = 6000,
                    date = Date(1661260000000) // 2022/08/23
                ),
                DayRecord(
                    totalStudyTime = 6200,
                    date = Date(1661310000000) // 2022/08/24
                ),
                DayRecord(
                    totalStudyTime = 10000,
                    date = Date(1661950000000) // 2022/08/31
                ),
                DayRecord(
                    totalStudyTime = 14000,
                    date = Date(1662550000000) // 2022/09/07
                ),
                DayRecord(
                    totalStudyTime = 16000,
                    date = Date(1662700000000) // 2022/09/09
                ),
                DayRecord(
                    totalStudyTime = 19000,
                    date = Date(1662800000000) // 2022/09/10
                ),
                DayRecord(
                    totalStudyTime = 19500,
                    date = Date(1662900000000) // 2022/09/11
                )
            )
        )
    }
}
