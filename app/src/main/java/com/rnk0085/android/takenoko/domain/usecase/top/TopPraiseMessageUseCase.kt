package com.rnk0085.android.takenoko.domain.usecase.top

import android.util.Log
import javax.inject.Inject

class TopPraiseMessageUseCase @Inject constructor() {
    operator fun invoke(): String {
        Log.d("debug", "TopPraiseMessageUseCase")

        // TODO: 条件に応じた褒めるメッセージのランダムで決める
        return "3日連続だね！\nすごい！！！"
    }
}
