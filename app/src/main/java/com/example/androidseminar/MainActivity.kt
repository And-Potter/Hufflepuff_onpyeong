package com.example.androidseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidseminar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId:String = binding.etId.text.toString()
        initButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.btnLogin.setOnClickListener {

            val userId = binding.etId.text

            if(userId.isNullOrBlank()) {
                Toast.makeText(this@MainActivity, "Id를 입력해주세요", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this@MainActivity, "안녕하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}