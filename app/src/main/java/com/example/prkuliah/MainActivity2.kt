package com.example.prkuliah

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    var edUsername: EditText? = null
    var edPassword: EditText? = null
    var btnSignIn: Button? = null
    var btnGoogleSign: Button? = null
    var btnSignUp : TextView? = null

    val PREF_KEY ="sharedSignUp"
    val KEY_NAME = "nameUser"
    val KEY_EMAIL= "emailUser"
    val KEY_TL = "tanggalLahirUser"
    val KEY_USERNAME = "username"
    val KEY_PASSWORD = "passwordUser"
    lateinit var  sharedPrefere: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main2)

        sharedPrefere = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)

        edUsername = findViewById(R.id.edUsernameLogin)
        edPassword = findViewById(R.id.edPassowrdLogin)
        btnGoogleSign = findViewById(R.id.signInGoogle)
        btnSignIn = findViewById(R.id.btnSigninLogin)
        btnSignUp = findViewById(R.id.btnSignUpLogin)

        btnSignUp?.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        })

        btnSignIn?.setOnClickListener(View.OnClickListener {
            var username: String = edUsername?.text.toString()
            var password: String = edPassword?.text.toString()
            var usernameSignUp : String? = sharedPrefere.getString(KEY_USERNAME,"0")
            var passwordSignUp : String? = sharedPrefere.getString(KEY_PASSWORD,"0")

            if (username.trim().length > 0 && password.trim().length>0) {
                if (username == usernameSignUp && password == passwordSignUp) {
                    Toast.makeText(applicationContext,"berhasil!",Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,DashboardActivity::class.java))
                }
                else{
                    Toast.makeText(applicationContext,"wrong username and password",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext,"username or password can not be null",Toast.LENGTH_SHORT).show()
            }

        })
        btnGoogleSign?.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"coming soon!",Toast.LENGTH_SHORT).show()
        })

    }
}