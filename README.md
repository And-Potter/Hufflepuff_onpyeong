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





# 🔥 Week 4



💛 **LEVEL-1**



🐣 **PostMan test**

![postman](https://user-images.githubusercontent.com/70002218/118391260-601b6d00-b66e-11eb-9a16-f43e18f8f7a6.png)



🐣 **회원가입 완료 gif**

![signup2](https://user-images.githubusercontent.com/70002218/118391230-306c6500-b66e-11eb-972a-301bb934a10f.gif)



🐣 **로그인 완료 gif**

![login](https://user-images.githubusercontent.com/70002218/118391209-192d7780-b66e-11eb-8c64-460161593985.gif)



🐣 **로그인/ 회원가입 서버통신**



**1. Retrofit Interface 설계**

```kotlin
interface SoptService {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>

    @POST("/login/signup")
    fun postSignUp(
        @Body body: RequestSignUpData
    ) : Call<ResponseSignUpData>
}
```



**2. 서버 Request, Response 객체 설계**

- json과 동일하게 data class로 만듦

- RequestLoginData

```kotlin
data class RequestLoginData(
    @SerializedName("email")
    val id: String,
    val password: String
)
```

- ResponseLoginData

```kotlin
data class ResponseLoginData(
    val success: Boolean,
    val message: String,
    val data: LoginData?
)

data class  LoginData(
    @SerializedName("UserId")
    val userId: Int,
    val user_nickname: String,
    val token: String
)
```



**3. Retrofit Interface 구현체**

- Singleton 패턴

```kotlin
object ServiceCreator {
    private const val BASE_URL = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)
}
```



**4. callback 등록, 서버 통신 구현**

- Call<Type> : 동기 혹은 비동기적으로 Type를 서버에서 받아오는 객체

- Callback<Type> : Type 객체를 비동기적으로 받아왔을때, 프로그래머가 할 행동

  

- **로그인** 

```kotlin
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
                        
                        // 홈 화면으로 넘어감
                        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this@SignInActivity, "로그인 성공", Toast.LENGTH_SHORT).show()

                    } else {
                        // 서버 통신 status가 200~300이 아닌 경우
                        Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
                    }
                }

                // 네트워크 통신 자체가 실패한 경우 해당 함수를 retrofit이 실행
                override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                    Log.d("NetworkTest", "error:$t")
                }
            })
```


