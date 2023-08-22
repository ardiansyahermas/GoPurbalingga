package com.application.wisataapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.application.wisataapp.db.DatabaseHandler

class RegisterActivity : AppCompatActivity() {

    private lateinit var btnRegister : Button

    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister = findViewById(R.id.btnRegister)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)

        setListener()
    }

    private fun setListener(){
        val db = DatabaseHandler(this)
        val listUser = db.allUser

        btnRegister.setOnClickListener {
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

            val isUser = listUser.any {it.email == email}
            if (isUser){
                Toast.makeText(this, "Email sudah terdaftar .Silahkan gunakan email lain!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                db.register(dataUser)

                Toast.makeText(this, "Daftar akun berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
}