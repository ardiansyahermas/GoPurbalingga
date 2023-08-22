package com.application.wisataapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.application.wisataapp.db.DatabaseHandler

class LoginActivity : AppCompatActivity() {

    private lateinit var btnRegister : Button
    private lateinit var btnLogin : Button

    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = SessionManager(this)

        btnRegister = findViewById(R.id.btnRegister)
        btnLogin = findViewById(R.id.btnLogin)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)

        setListener()
    }

    private fun setListener(){
        val db = DatabaseHandler(this)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "Email harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                Toast.makeText(this, "Password harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val dataUser = DataUser(0,email, password)

            val listUser = db.allUser

            if (listUser.isEmpty()){
                Toast.makeText(this, "Email Anda belum terdaftar .Silahkan daftar terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                val isUser = listUser.any { it.email == email && it.password == password }

                if (isUser){
                    sessionManager.isLogin(true)
                    sessionManager.dataUser = dataUser

                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Email atau password salah!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

}