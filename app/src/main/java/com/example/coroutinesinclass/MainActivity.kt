package com.example.coroutinesinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    val timerTextView: TextView by lazy {
        findViewById(R.id.timerTextView)
    }

    val startButton: Button by lazy {
        findViewById(R.id.startButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener() {
            CoroutineScope(Job() + Dispatchers.Default).launch {

                repeat(100) {
                    (100 - it).toString().run {
                        Log.d("Countdown", it.toString())
                        withContext(Dispatchers.Main) {
                            timerTextView.text = this@run
                        }
                    }
                    delay(1000)
                }
            }
        }
    }
}