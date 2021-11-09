package io.github.runnlin.AndroidDecoderTester

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import androidx.annotation.Nullable

class AIDLRemoteService:Service() {

    private val aidl: CustomAIDL.Stub = object : CustomAIDL.Stub() {
        @Throws(RemoteException::class)
        override fun getStr(): String {
            return " 我是远程服务返回的 HELLO "
        }
    }

    @Nullable
    override fun onBind(intent: Intent?): IBinder {
        return aidl
    }

}