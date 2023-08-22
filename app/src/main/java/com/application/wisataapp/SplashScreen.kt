package com.application.wisataapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sessionManager = SessionManager(this)

        Handler().postDelayed({
                              if (sessionManager.isLogin()){
                                  startActivity(Intent(this, MainActivity::class.java))
                                  finish()
                              } else {
                                  startActivity(Intent(this, LoginActivity::class.java))
                                  finish()
                              }
        }, 2000)


    }
}