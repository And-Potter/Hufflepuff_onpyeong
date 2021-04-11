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

![](C:\Users\강수현\Desktop\KakaoTalk_20210411_190958314.png)


🐣 **추가**

공부해야 할 내용이 많다.. 복습 필수!

