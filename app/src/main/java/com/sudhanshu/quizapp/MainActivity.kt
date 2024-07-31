package com.sudhanshu.quizapp


import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.github.ybq.android.spinkit.style.WanderingCubes
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.sudhanshu.quizapp.databinding.ActivityMainBinding
import java.util.logging.Handler


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()//for full screen
        setContentView(binding.root)


        val progressBar = findViewById<View>(R.id.spin_kit) as ProgressBar
        val wanderingCubes: Sprite = WanderingCubes()
        progressBar.indeterminateDrawable = wanderingCubes

        android.os.Handler(Looper.getMainLooper()).postDelayed(1000) {
            if(Firebase.auth.currentUser !=null)
            {
                val intent = Intent(this, Question::class.java)
                startActivity(intent)
                finish()
            }else {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}