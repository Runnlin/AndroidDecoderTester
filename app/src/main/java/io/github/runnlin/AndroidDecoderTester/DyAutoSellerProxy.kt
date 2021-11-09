package io.github.runnlin.AndroidDecoderTester

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class DyAutoSellerProxy(var any: Any) : InvocationHandler {

    val handler = InvocationHandler { _, method, _ ->
        method.invoke(any)
    }

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
        return handler
    }

}