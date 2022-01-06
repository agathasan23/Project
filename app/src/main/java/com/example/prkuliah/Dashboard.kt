package com.example.prkuliah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.prkuliah.databinding.ActivityDashboardBinding
import com.google.firebase.auth.FirebaseAuth


class Dashboard : AppCompatActivity() {
    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,Login::class.java))
            finish()
        }
        binding.imgAddEvent.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,AddEvent::class.java)
            startActivity(intent)
        })

        binding.cView1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Category::class.java)
            intent.putExtra("categoryId",1)
            startActivity(intent)
        })

        binding.cView2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Category::class.java)
            intent.putExtra("categoryId",2)
            startActivity(intent)
        })

        binding.cView3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Category::class.java)
            intent.putExtra("categoryId",3)
            startActivity(intent)
        })

        binding.cView4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Category::class.java)
            intent.putExtra("categoryId",4)
            startActivity(intent)
        })

        binding.cView5.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Category::class.java)
            intent.putExtra("categoryId",5)
            startActivity(intent)
        })

        binding.cView6.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Category::class.java)
            intent.putExtra("categoryId",6)
            startActivity(intent)
        })

    }


}