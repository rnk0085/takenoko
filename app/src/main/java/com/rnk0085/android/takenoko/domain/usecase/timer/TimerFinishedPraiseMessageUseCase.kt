package com.rnk0085.android.takenoko.domain.usecase.timer

import android.util.Log
import javax.inject.Inject

class TimerFinishedPraiseMessageUseCase @Inject constructor() {
    operator fun invoke(): String {
        Log.d("debug", "TimerFinishedPraiseMessageUseCase")

        // TODO: メッセージをランダムに返す
        return "流石！\n頑張り屋さんだね"
    }
}
