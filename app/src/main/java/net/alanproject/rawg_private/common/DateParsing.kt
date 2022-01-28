package net.alanproject.rawg_private.common

import android.os.Build
import timber.log.Timber
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun dateParsing(past:Boolean, period:Long):String {

    val today = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDate.now()
    } else {
        TODO("VERSION.SDK_INT < O")
    }

    Timber.d("1) currentTime:  $today")

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    Timber.d("2) currentTime:  ${today.format(formatter)}")

    return if(past){
        "${today.minusDays(period)},$today"
    }else{
        "${today.plusDays(1)},${today.plusDays(period)}"
    }
}
