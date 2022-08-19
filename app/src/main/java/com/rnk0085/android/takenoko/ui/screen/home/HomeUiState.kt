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
                DayRecord(
                    totalStudyTime = 10000,
                    date = Date(1661310000000) // 2022/08/24
                ),
                DayRecord(
                    totalStudyTime = 13000,
                    date = Date(1661410000000) // 2022/08/25
                ),
                DayRecord(
                    totalStudyTime = 13100,
                    date = Date(1661610000000)
                ),
                DayRecord(
                    totalStudyTime = 14000,
                    date = Date(1661910000000)
                ),
                DayRecord(
                    totalStudyTime = 14500,
                    date = Date(1663000000000)
                ),
            )
        )
    }
}
