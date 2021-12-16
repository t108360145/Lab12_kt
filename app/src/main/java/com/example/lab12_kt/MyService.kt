package com.example.lab12_kt

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        val intent = Intent(this, SecActivity::class.java)
        runBlocking {
            launch {
                try{
                    delay(3000)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
        }

    }

    override fun onStartCommand(intent: Intent,
                                flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder?=null
}