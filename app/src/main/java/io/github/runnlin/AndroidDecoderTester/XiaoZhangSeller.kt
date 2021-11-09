package io.github.runnlin.AndroidDecoderTester

import android.util.Log
import io.github.runnlin.AndroidDecoderTester.bean.User

class XiaoZhangSeller(var user: User) : ISellTicket {

    override fun sellTicket() {
        Log.i("", "买票者的信息===============");

        Log.i("", "买票者姓名：" + user.uname);
        Log.i("", "买票性别：" + user.sex);
        Log.i("", "买票者身份证号：" + user.idNum);
        Log.i("", "买票者住址：" + user.address);

        Log.i("", "==============================");

        Log.i("", "正在验证信息...信息无误,请支付票钱");
        Log.i("", "买票者支付:" + user.pay + " 元");
        Log.i("", "请稍等正在出票.....");
        Log.i("", "出票成功:从西安到宝鸡大巴进站去坐");
    }
}