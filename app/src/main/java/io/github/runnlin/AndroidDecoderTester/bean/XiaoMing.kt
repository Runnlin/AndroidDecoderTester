package io.github.runnlin.AndroidDecoderTester.bean

import android.util.Log
import io.github.runnlin.AndroidDecoderTester.ZhuimmWay

class XiaoMing:ZhuimmWay {

    val TAG:String = "PROXYTEST"

    private lateinit var mm:MM

    fun like(mm: MM) {
        this.mm = mm
    }

    override fun giveFlower() {
        Log.i(TAG, mm.name+"送你一朵小红花")
    }

    override fun writeLoveLetters() {
        Log.i(TAG, mm.name+"给你情书")
    }

    override fun buyClothes() {
        Log.i(TAG, mm.name+"给你买衣服")
    }

    override fun doSomething() {
        Log.i(TAG, mm.name+"干点别的")
    }

}
