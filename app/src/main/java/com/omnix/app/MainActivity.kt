package com.omnix.app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStartService)
        val btnStop = findViewById<Button>(R.id.btnStopService)

        btnStart.setOnClickListener {
            val serviceIntent = Intent(this, OmniBackgroundService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }

        btnStop.setOnClickListener {
            val serviceIntent = Intent(this, OmniBackgroundService::class.java)
            stopService(serviceIntent)
        }
    }
}
