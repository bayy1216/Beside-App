package com.beside.hackathon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.beside.hackathon.databinding.ActivitySplashBinding

fun isLoggedIn(context: Context): Boolean {
    val sharedPreferences = context.getSharedPreferences(
        "mPref",
        Context.MODE_PRIVATE
    )
    return sharedPreferences.getString("accessToken", "") != ""
}
class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        // 스플래시 화면 클릭 시 메인 액티비티로 이동
//        findViewById<ConstraintLayout>(R.id.splash_activity).setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//            handler?.removeCallbacksAndMessages(null)
//        }

        /* Status Bar & Navigation Bar */
        val barColor = ContextCompat.getColor(this, R.color.white)
        with(window) {
            statusBarColor = barColor
        }
        with(WindowInsetsControllerCompat(window, window.decorView)) {
            isAppearanceLightStatusBars = true
        }

        // 스플래시 화면 디스플레이 시간 조절 (예: 2000 밀리초, 즉 2초)
        setInitialize(10)
    }

    private fun setInitialize(delayMillis: Long) {
        handler = Handler(Looper.getMainLooper())
        val intent =  Intent(this, MainActivity::class.java)
        val isLogin = isLoggedIn(this)
        intent.putExtra("isLogin", isLogin)
        handler?.postDelayed({
            startActivity(intent)
            finish()
        }, delayMillis)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacksAndMessages(null)
    }

    // ...
}