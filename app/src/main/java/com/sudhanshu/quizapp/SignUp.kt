package com.sudhanshu.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.sudhanshu.quizapp.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)



       binding.signup.setOnClickListener {
           val name = binding.name.text.toString()
           val email = binding.email.text.toString()
           val password = binding.password.text.toString()
           val confirmPassword = binding.repassword.text.toString()
           if (password == confirmPassword && email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()) {
               Firebase.auth.createUserWithEmailAndPassword(email, password)
                   .addOnCompleteListener {
                       if (it.isSuccessful) {
                           Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()
                           val intent = Intent(this,Question::class.java)
                           startActivity(intent)
                           finish()
                       } else {
                           Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                       }
                   }
           } else {
               Toast.makeText(this, "Fill all fields", Toast.LENGTH_LONG).show()
           }
       }
        binding.alreadyuser.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }






    }
}