package com.example.prkuliah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.prkuliah.databinding.ActivityCategoryBinding

class Category : AppCompatActivity() {

    private val binding by lazy { ActivityCategoryBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        val intent = intent


        binding.tvCategory.text = intent.getIntExtra("categoryId",1).toString()

        binding.imgBackCategory.setOnClickListener(View.OnClickListener {
            super.onBackPressed()
        })
    }
}