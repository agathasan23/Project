package com.example.prkuliah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.prkuliah.databinding.ActivityAddEventBinding

class AddEvent : AppCompatActivity() {
    private val binding by lazy { ActivityAddEventBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.imgBackAddEvent.setOnClickListener(View.OnClickListener {
            super.onBackPressed()
        })
    }
}