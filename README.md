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

