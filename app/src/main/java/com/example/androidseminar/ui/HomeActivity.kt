package com.example.androidseminar.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.androidseminar.data.RepoInfo
import com.example.androidseminar.data.SoptUserAuthStorage
import com.example.androidseminar.databinding.ActivityHomeBinding
import com.example.androidseminar.toast

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var repoListAdapter: RepoListAdapter

    private val userInfoActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ) {
        // 데이터를 받아서 할 일이 들어가는 칸!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moreButtonClickEvent()
        logoutButtonClickEvent()
        initRepoListRecyclerView()

        Log.d("lifeCycle", "Home_onCreate")
    }

    private fun moreButtonClickEvent() {
        binding.btnMore.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            userInfoActivityLauncher.launch(intent)
        }
    }

    private fun logoutButtonClickEvent() {
        binding.btnLogout.setOnClickListener{
            SoptUserAuthStorage.clearAutoLogin()
            navigateSignIn()
            toast("로그아웃")
        }
    }

    fun navigateSignIn() {
        val intent = Intent(this@HomeActivity, SignInActivity::class.java)
        startActivity(intent)
    }

    private fun initRepoListRecyclerView() {
        repoListAdapter = RepoListAdapter()

        binding.rvRepoList.adapter = repoListAdapter

        repoListAdapter.repoList.addAll(
            listOf<RepoInfo>(
                RepoInfo(
                    repoName = "REPO 1 : And-Potter\\hufflepuff_onpyeong",
                    repoDisc = "SOPT 28기 안드로이드 3조 후플푸프 기숙사의 과제 제출함" +
                            "\n#YB #Android #hufflepuff #Seminar #Assignment #배워가는 중 ",
                    repoLanguage = "kotlin"
                ),
                RepoInfo(
                    repoName = "REPO 2 : mdb1217\\Baekjoon_Jojeo",
                    repoDisc = "일주일 백준 2문제 풀기 스터디" +
                            "\n#BOJ #Challenge #Study",
                    repoLanguage = "c++  java"
                ),
                RepoInfo(
                    repoName = "REPO 3 : onpyeong\\BOJ_Challenge",
                    repoDisc = "백준 하루 한문제 이상 풀기 챌린지" +
                            "\n#BOJ #Challenge #Class3",
                    repoLanguage = "c++"
                ),
                RepoInfo(
                    repoName = "REPO 4 : onpyeong\\gitbootest",
                    repoDisc = "깃뿌 스터디 연습용" +
                            "\n#Git #Github #Study",
                    repoLanguage = "kotlin"
                ),
                RepoInfo(
                    repoName = "REPO 5 : BackEndBoostCamp\\Assignment",
                    repoDisc = "백엔드 스터디 과제 제출함" +
                            "\n#BackEnd #Study",
                    repoLanguage = "java"
                )
            )
        )
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