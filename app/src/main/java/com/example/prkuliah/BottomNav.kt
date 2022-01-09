package com.example.prkuliah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import com.example.prkuliah.databinding.ActivityBottomNavBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNav : AppCompatActivity() {

    val fragmentDashboard = Dashboard()
    val fragmentEvent = Event()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        makeCurrentFragement(fragmentDashboard)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)

        bottomNav.setOnNavigationItemSelectedListener{
            when (it.itemId){
                R.id.menu_home -> makeCurrentFragement(fragmentDashboard)
                R.id.menu_event -> makeCurrentFragement(fragmentEvent)
            }
            true
        }




    }

    private fun makeCurrentFragement(fragment: Fragment) =
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()


    override fun onBackPressed() {
        finish()
    }
}