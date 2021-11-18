package io.github.runnlin.decoder_tester

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import androidx.annotation.Nullable

class AIDLRemoteService:Service() {

    private val aidl: CustomAIDL.Stub = object : CustomAIDL.Stub() {
        @Throws(RemoteException::class)
        override fun getDecoders(type: Int): String {
            TODO("Not yet implemented")
        }
        @Throws(RemoteException::class)
        override fun checkDecoders(decoders: String?): String {
            TODO("Not yet implemented")
        }
    }

    @Nullable
    override fun onBind(intent: Intent?): IBinder {
        return aidl
    }

}