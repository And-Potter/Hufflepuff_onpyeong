# 🚕 Week 1



🐣 **화면 전환과 데이터 보내기**

- SignInActivity -> HomeActivity

```kotlin
val intent = Intent(this, HomeActivity::class.java)
startActivity(intent)
```

- SignInActivity -> SignUpActivity

```kotlin
private val signUpActivityLauncher = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
) {
    // 데이터를 받아서 할 일이 들어가는 칸!
}

val intent = Intent(this, SignUpActivity::class.java)
signUpActivityLauncher.launch(intent)
```

- SignUpActivity -> SignInActivity

```kotlin
val intent = Intent()
intent.putExtra("name", binding.edtName.text.toString())
intent.putExtra("id", binding.etId.text.toString())
intent.putExtra("password", binding.etPassword.text.toString())
setResult(Activity.RESULT_OK, intent)
finish()
```



🐣 **생명주기와 Log띄우기**

![KakaoTalk_20210411_190958314](https://user-images.githubusercontent.com/70002218/114304910-9ebe8480-9b10-11eb-86b9-a8f89eba13ad.png)



🐣 **추가**

공부해야 할 내용이 많다.. 복습 필수!





# 🔥 Week 2



💛 **LEVEL-1**



🐣 **레포지터리 리스트 띄우기(RecyclerView)**

- **item_repo.xml**

  - 조건 2가지

  - 레포지터리 이름, 설명이 긴 경우 뒤에 ... 붙이기

  - **ellipsize, maxLines** 이용

    ```kotlin
    <TextView
            android:id="@+id/tv_repo_name"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:textStyle="bold"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            android:ellipsize="end" //뒤에 ... 붙이기
            android:maxLines="1" //최대 1줄
            tools:text="@string/repo_name"/>
    ```

- **RepoInfo** data class 정의

```kotlin
data class RepoInfo (
        val repoName: String,
        val repoDisc: String,
        val repoLanguage: String
)
```

- **RepoListAdapter** 정의

```kotlin
class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> () {

    val repoList = mutableListOf<RepoInfo>() //데이터정보

    //뷰홀더에게 현재 상황 알려주기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder { 
        val binding = ItemRepoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ) 
        return RepoViewHolder(binding)
    }

    override fun getItemCount(): Int = repoList.size //데이터의 총 개수를 알려줌

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(repoList[position]) //데이터를 원하는 위치부터 뷰에 묶기
    }

    class RepoViewHolder(
            private val binding: ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(repoInfo: RepoInfo) {
            binding.tvRepoName.text = repoInfo.repoName
            binding.tvRepoDisc.text = repoInfo.repoDisc
            binding.tvRepoLanguage.text = repoInfo.repoLanguage
        }
    }

}
```

- HomeActivity에서 **initRepoListRecyclerView()**함수
  - repoList에 데이터를 담아 Adapter에 전달

```kotlin
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
```



🐣 **more버튼 누르면 UserInfoActivity로 이동하기**

- **userInfoActivityLauncher** 정의

```kotlin
private val userInfoActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ) {
        // 데이터를 받아서 할 일이 들어가는 칸!
    }
```

- **moreButtonClickEvent()**

```
private fun moreButtonClickEvent() {
    binding.btnMore.setOnClickListener {
        val intent = Intent(this, UserInfoActivity::class.java)
        userInfoActivityLauncher.launch(intent)
    }
}
```


