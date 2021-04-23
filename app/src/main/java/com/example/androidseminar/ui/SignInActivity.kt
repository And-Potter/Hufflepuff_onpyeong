package com.example.androidseminar.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidseminar.ui.HomeActivity
import com.example.androidseminar.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignInBinding

    private val signUpActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ) {
        // 데이터를 받아서 할 일이 들어가는 칸!
        if(it.resultCode == Activity.RESULT_OK) {
            with(binding) {
                etId.setText(it.data!!.getStringExtra("id"))
                etPassword.setText(it.data!!.getStringExtra("password"))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginButtonClickEvent()
        signUpButtonClickEvent()
        Log.d("lifeCycle", "SignIn_onCreate")
    }

    private fun loginButtonClickEvent() {
        binding.btnLogin.setOnClickListener {

            val userId = binding.etId.text
            val userPassword = binding.etPassword.text

            if(userId.isNullOrBlank() || userPassword.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            }else {
                //화면 이동
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

                Toast.makeText(this@SignInActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUpButtonClickEvent() {
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "SignIn_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "SignIn_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "SignIn_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "SignIn_onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "SignIn_onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "SignIn_onDestroy")
    }
}