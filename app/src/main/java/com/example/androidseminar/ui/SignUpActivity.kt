package com.example.androidseminar.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidseminar.api.ServiceCreator
import com.example.androidseminar.data.reponse.ResponseLoginData
import com.example.androidseminar.data.reponse.ResponseSignUpData
import com.example.androidseminar.data.request.RequestLoginData
import com.example.androidseminar.data.request.RequestSignUpData
import com.example.androidseminar.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            val requestSignUpData = RequestSignUpData(
                id = binding.etId.text.toString(),
                password = binding.etPassword.text.toString(),
                sex = "0",
                nickname = "test",
                phone = "010-0000-0000",
                birth = "2021-05-13"
            )

            val call: Call<ResponseSignUpData> = ServiceCreator.soptService
                .postSignUp(requestSignUpData)
            call.enqueue(object : Callback<ResponseSignUpData> {
                override fun onResponse(
                    call : Call<ResponseSignUpData>,
                    response: Response<ResponseSignUpData>
                ) {
                    if(response.isSuccessful) {
                        val data = response.body()?.data
                        // 홈 화면으로 넘어감
                        val intent = Intent()
                        with (intent) {
                            putExtra("password", binding.etPassword.text.toString())
                            putExtra("id", binding.etId.text.toString())
                            putExtra("name", binding.edtName.text.toString())
                        }
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                        Toast.makeText(this@SignUpActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    } else {
                        // 서버 통신 status가 200~300이 아닌 경우
                        Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
                    }
                }

                // 네트워크 통신 자체가 실패한 경우 해당 함수를 retrofit이 실행
                override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                    Log.d("NetworkTest", "error:$t")
                }
            })
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