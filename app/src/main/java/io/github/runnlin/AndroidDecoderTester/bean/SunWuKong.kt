package io.github.runnlin.AndroidDecoderTester.bean

import android.util.Log
import io.github.runnlin.AndroidDecoderTester.IToWest

open class SunWuKong:IToWest {

    val TAG = "SunWuKong"

    override fun baohuTangSeng() {
        Log.i(TAG, "我孙悟空保护123")
    }

    override fun xiangyaoChuMo() {
        Log.i(TAG, "我孙悟空降妖")
    }

    override fun shangTianRuDi() {
        Log.i(TAG, "我孙悟空上天")
    }

}