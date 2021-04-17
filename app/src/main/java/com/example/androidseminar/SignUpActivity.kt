package com.example.androidseminar

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidseminar.databinding.ActivitySignInBinding
import com.example.androidseminar.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpButtonClickEvent()
        Log.d("lifeCycle", "SignUp_onCreate")
    }

    private fun signUpButtonClickEvent() {
        binding.btnSignUp.setOnClickListener {

            val userName = binding.edtName.text
            val userId = binding.etId.text
            val userPassword = binding.etPassword.text

            if(userName.isNullOrBlank() || userId.isNullOrBlank() || userPassword.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            }else {
                //화면 이동
                val intent = Intent()
                with (intent) {
                    putExtra("password", binding.etPassword.text.toString())
                    putExtra("id", binding.etId.text.toString())
                    putExtra("name", binding.edtName.text.toString())
                }
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "SignUp_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "SignUp_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "SignUp_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "SignUp_onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "SignUp_onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "SignUp_onDestroy")
    }

}