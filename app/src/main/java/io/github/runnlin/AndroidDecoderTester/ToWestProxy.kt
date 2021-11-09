package io.github.runnlin.AndroidDecoderTester

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

class ToWestProxy {

    lateinit var delegate: Any

    private val handler = InvocationHandler { _, method, _ ->
        method.invoke(delegate)
    }

    fun getProxy(delegate: Any): Any {
        this.delegate = delegate
        return Proxy.newProxyInstance(delegate.javaClass.classLoader, delegate.javaClass.interfaces, handler)
    }
}