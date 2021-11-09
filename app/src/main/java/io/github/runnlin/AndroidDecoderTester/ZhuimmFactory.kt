package io.github.runnlin.AndroidDecoderTester

import io.github.runnlin.AndroidDecoderTester.bean.MM
import io.github.runnlin.AndroidDecoderTester.bean.ProxyXiaoMing
import io.github.runnlin.AndroidDecoderTester.bean.XiaoMing

class ZhuimmFactory {
    companion object {
        fun getInstance(name:String):ProxyXiaoMing {
            return ProxyXiaoMing(XiaoMing(), MM(name))
        }
    }
}