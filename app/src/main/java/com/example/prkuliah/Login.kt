package com.example.prkuliah

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.prkuliah.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class Login : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private lateinit var mAuth : FirebaseAuth
    private lateinit var googleSignInClient : GoogleSignInClient

    companion object{
        private const val RC_SIGN_IN = 120
    }
//    var edUsername: EditText? = null
//    var edPassword: EditText? = null
//    var btnSignIn: Button? = null
//    var btnGoogleSign: Button? = null
//    var btnSignUp : TextView? = null
//
//    val PREF_KEY ="sharedSignUp"
//    val KEY_NAME = "nameUser"
//    val KEY_EMAIL= "emailUser"
//    val KEY_TL = "tanggalLahirUser"
//    val KEY_USERNAME = "username"
//    val KEY_PASSWORD = "passwordUser"
//    lateinit var  sharedPrefere: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(binding.root)

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        sharedPrefere = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
//
//        edUsername = findViewById(R.id.edEmailLogin)
//        edPassword = findViewById(R.id.edPassowrdLogin)
//        btnGoogleSign = findViewById(R.id.signInGoogle)
//        btnSignIn = findViewById(R.id.btnSigninLogin)
//        btnSignUp = findViewById(R.id.btnSignUpLogin)

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        mAuth = FirebaseAuth.getInstance()

        binding.signInGoogle.setOnClickListener {
            signIn()
        }

        binding.btnSignUpLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
        })

        binding.btnSigninLogin.setOnClickListener{
            when{
                TextUtils.isEmpty(binding.edEmailLogin.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@Login,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(binding.edPassowrdLogin.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@Login,
                        "Please enter password",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = binding.edEmailLogin.text.toString().trim{ it <= ' '}
                    val password: String = binding.edPassowrdLogin.text.toString().trim{ it <= ' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            OnCompleteListener { task ->
                                if (task.isSuccessful){
                                    val firebaseUser : FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@Login,
                                        "Logged In",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent = Intent(this@Login, Dashboard::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("userId", FirebaseAuth.getInstance().currentUser!!.uid)
                                    intent.putExtra("email", email)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this@Login,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                }
            }
        }



//        btnSignIn?.setOnClickListener(View.OnClickListener {
//            var username: String = edUsername?.text.toString()
//            var password: String = edPassword?.text.toString()
//            var usernameSignUp : String? = sharedPrefere.getString(KEY_USERNAME,"0")
//            var passwordSignUp : String? = sharedPrefere.getString(KEY_PASSWORD,"0")
//
//            if (username.trim().length > 0 && password.trim().length>0) {
//                if (username == usernameSignUp && password == passwordSignUp) {
//                    Toast.makeText(applicationContext,"berhasil!",Toast.LENGTH_LONG).show()
//                    startActivity(Intent(this,Dashboard::class.java))
//                }
//                else{
//                    Toast.makeText(applicationContext,"wrong username and password",Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(applicationContext,"username or password can not be null",Toast.LENGTH_SHORT).show()
//            }
//
//        })
//        btnGoogleSign?.setOnClickListener(View.OnClickListener {
//            Toast.makeText(applicationContext,"coming soon!",Toast.LENGTH_SHORT).show()
//        })

    }
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("Login", "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("login", "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Login", "signInWithCredential:success")

                    Toast.makeText(
                        this@Login,
                        "Logged In",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this,Dashboard::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Login", "signInWithCredential:failure", task.exception)
                }
            }
    }
}