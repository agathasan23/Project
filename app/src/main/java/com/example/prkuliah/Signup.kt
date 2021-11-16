package com.example.prkuliah

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class Signup : AppCompatActivity() {

    val PREF_KEY ="sharedSignUp"
    val KEY_NAME = "nameUser"
    val KEY_EMAIL= "emailUser"
    val KEY_TL = "tanggalLahirUser"
    val KEY_USERNAME = "username"
    val KEY_PASSWORD = "passwordUser"
    lateinit var  sharedPrefere: SharedPreferences

    var imgBackBtn: ImageView? = null
    var edNameUser: EditText? = null
    var edEmailUser: EditText? = null
    var edTanggalLahir: EditText? = null
    var edUsername: EditText? = null
    var edPassword: EditText? = null
    var edConfirmPassword: EditText? = null
    var btnSignUp: Button? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        sharedPrefere = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
        val shrdPref:SharedPreferences.Editor = sharedPrefere.edit()

        setContentView(R.layout.activity_signup)
        imgBackBtn = findViewById(R.id.imgBackSignUp)
        edNameUser = findViewById(R.id.edName)
        edEmailUser  = findViewById(R.id.edEmail)
        edTanggalLahir = findViewById(R.id.edBornDate)
        edUsername = findViewById(R.id.edUsername)
        edPassword = findViewById(R.id.edPassowrd)
        edConfirmPassword = findViewById(R.id.edCpassowrd)
        sharedPrefere = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)


        btnSignUp = findViewById(R.id.btnSignUp)
        imgBackBtn?.setOnClickListener(View.OnClickListener {
            super.onBackPressed()
        })

        btnSignUp?.setOnClickListener(View.OnClickListener {
            var nameUser = edNameUser?.text.toString()
            var emailUser = edEmailUser?.text.toString()
            var tanggalLahir = edTanggalLahir?.text.toString()
            var username = edUsername?.text.toString()
            var password = edPassword?.text.toString()
            var confPassword = edConfirmPassword?.text.toString()

            if (nameUser.trim().length > 0 && emailUser.trim().length > 0 && password.trim().length > 0 ){
                if (confPassword.equals(password)){
                    shrdPref.putString(KEY_NAME,nameUser)
                    shrdPref.putString(KEY_EMAIL,emailUser)
                    shrdPref.putString(KEY_TL,tanggalLahir)
                    shrdPref.putString(KEY_USERNAME,username)
                    shrdPref.putString(KEY_PASSWORD,password)
                    shrdPref.apply()
                    startActivity(Intent(this,Login::class.java))
                }else{
                    Toast.makeText(applicationContext,"Password doest match",Toast.LENGTH_SHORT).show()

                }
            }else{
                Toast.makeText(applicationContext,"please , fill form",Toast.LENGTH_SHORT).show()
            }


        })


    }
}