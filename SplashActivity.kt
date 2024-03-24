package com.muhammaddayyanahmad.i210772

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Handler


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Optionally, you can add some delay or animation here before transitioning to the next activity
        // For example, using a Handler to delay the transition
        // Optionally, you can add some delay or animation here before transitioning to the next activity
        // For example, using a Handler to delay the transition
        android.os.Handler().postDelayed ({ // Start the next activity here
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // 3000 milliseconds = 3 seconds dela

    }
}