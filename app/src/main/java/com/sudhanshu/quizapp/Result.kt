package com.sudhanshu.quizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sudhanshu.quizapp.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val correctAnswers = intent.getIntExtra("correct_answer",0)
        val answers = correctAnswers.toString()
        Log.d("Finish_Correct_Answers", "Received correct answers:$answers")
        binding.score.text = "Your Score is $answers / 10"
        binding.finish.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}