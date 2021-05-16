package com.example.androidseminar.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidseminar.api.ServiceCreator
import com.example.androidseminar.data.reponse.ResponseLoginData
import com.example.androidseminar.data.request.RequestLoginData
import com.example.androidseminar.ui.HomeActivity
import com.example.androidseminar.databinding.ActivitySignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            // 서버로 보낼 로그인 데이터 생성
            val requestLoginData = RequestLoginData(
                id = binding.etId.text.toString(),
                password = binding.etPassword.text.toString()
            )
            // 현재 사용자의 정보를 받아올 것을 명시
            // 서버 통신은 I/O 작업이므로 비동기적으로 받아올 Callback 내부 코드는 나중에
            // 데이터를 받아오고 실행됨

            /* enqueue 함수를 이용해 Call이 비동기 작업 이후 동작함 Callback을 등록할 수 있음
            * 해당 함수 호출은 Callback을 등록만 하고
            * 실제 서버 통신을 요청이후 통신 결과가 나왔을 때 실행됨*/
            // object 키워드로 Callback을 구현할 익명 클래스 생성

            val call: Call<ResponseLoginData> = ServiceCreator.soptService
                .postLogin(requestLoginData)
            call.enqueue(object : Callback<ResponseLoginData> {
                // 네트워크 통신 Response가 있는 경우 해당 함수를 retrofit이 호출
                override fun onResponse(
                    call : Call<ResponseLoginData>,
                    response: Response<ResponseLoginData>
                ) {
                    // 네트워크 통신에 성공한 경우 status 코드가 200~300일 때 실행
                    if(response.isSuccessful) {
                        // response body 자체가 nullable 데이터, 서버에서 오는 data도 nullable
                        val data = response.body()?.data
                        // 통신 성공 시 유저 닉네임을 보여줌
                        Toast.makeText(this@SignInActivity, data?.user_nickname, Toast.LENGTH_SHORT)
                            .show()
                        // 홈 화면으로 넘어감
                        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this@SignInActivity, "로그인 성공", Toast.LENGTH_SHORT).show()

                    } else {
                        // 서버 통신 status가 200~300이 아닌 경우
                        // 에러가 났다면 어떻게 해야 할지...
                        Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
                    }
                }

                // 네트워크 통신 자체가 실패한 경우 해당 함수를 retrofit이 실행
                override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                    Log.d("NetworkTest", "error:$t")
                }
            })

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