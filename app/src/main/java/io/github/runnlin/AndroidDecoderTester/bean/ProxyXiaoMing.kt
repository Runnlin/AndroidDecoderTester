package io.github.runnlin.AndroidDecoderTester.bean

import io.github.runnlin.AndroidDecoderTester.ZhuimmWay

class ProxyXiaoMing(xiaoMing: XiaoMing, mm: MM):ZhuimmWay {

    private lateinit var xiaoMing:XiaoMing

    init {
        this.xiaoMing = xiaoMing
        xiaoMing.like(mm)
    }

    override fun giveFlower() {
        xiaoMing.giveFlower()
    }

    override fun writeLoveLetters() {
        xiaoMing.writeLoveLetters()
    }

    override fun buyClothes() {
        xiaoMing.buyClothes()
    }

    override fun doSomething() {
        xiaoMing.doSomething()
    }
}