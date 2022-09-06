package com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import javax.inject.Inject

class CalculateTimeOfBoxesUseCase @Inject constructor() {
    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(
        boxTime: String,
        hour: Int,
        minute: Int,
        boxAmount: String,
    ): List<LocalTime> =
        if (isDataCorrect(boxTime)) {
            val mutableList2 = mutableListOf<LocalTime>()
            var time = LocalTime.of(hour, minute)
            for (i in 1..boxAmount.toInt()) {
                time = time.plusMinutes(boxTime.toLong())
                mutableList2.add(time)
            }
            mutableList2
        } else {
            emptyList()
        }


    private fun isDataCorrect(
        boxTime: String,
    ) = boxTime.isNotBlank() && boxTime.toInt() != 0
}