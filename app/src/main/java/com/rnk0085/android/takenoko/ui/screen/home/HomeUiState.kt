package com.rnk0085.android.takenoko.ui.screen.home

import com.rnk0085.android.takenoko.domain.model.DayRecord
import java.util.*

data class HomeUiState(
    val dayRecords: List<DayRecord> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
) {
    companion object {
        val InitialValue = HomeUiState(
            dayRecords = listOf(
                DayRecord(
                    totalStudyTime = 1000,
                    date = Date(1660950000000) // 2022/08/19
                ),
                DayRecord(
                    totalStudyTime = 2000,
                    date = Date(1660960000000) // 2022/08/20
                ),
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

                // TODO: 5つ以上でも適切に表示できるように修正
//                DayRecord(
//                    totalStudyTime = 10000,
//                    date = Date(1661310000000) // 2022/08/24
//                ),
//                DayRecord(
//                    totalStudyTime = 100000,
//                    date = Date(1661410000000) // 2022/08/25
//                ),
            )
        )
    }
}
