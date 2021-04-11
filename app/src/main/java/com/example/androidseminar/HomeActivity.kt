package com.example.androidseminar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidseminar.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("lifeCycle", "Home_onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "Home_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "Home_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "Home_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "Home_onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "Home_onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "Home_onDestroy")
    }
}