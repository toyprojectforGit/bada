package com.example.bada1.util

import android.util.Log
import com.example.bada1.util.util.TAG
import java.text.SimpleDateFormat
import java.util.*

object util {
    val TAG = "로그"
}
fun parseTimeToHome():String{
    val tmp = System.currentTimeMillis()
    val home_dateFormat= SimpleDateFormat("MM.dd.E", Locale("En", "KR"))
    val parseData=home_dateFormat.format(tmp)
    Log.d(TAG,"현재 날짜 ${parseData}")
    return parseData
}