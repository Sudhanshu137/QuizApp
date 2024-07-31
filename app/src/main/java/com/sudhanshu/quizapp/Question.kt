package com.sudhanshu.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sudhanshu.quizapp.databinding.ActivityQuestionBinding

class Question : AppCompatActivity() {
    private var mCurrentpos: Int = 1
    private var mQuestionList: ArrayList<QuestionModel>? = null
    private var mSelectedOptionPosition: Int = 0
    private lateinit var binding: ActivityQuestionBinding
    private var mCorrectanswer: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        mQuestionList = Constants.getquestion()
        setquestion()

        binding.option1.setOnClickListener {
            optionclick(1)
        }
        binding.option2.setOnClickListener {
            optionclick(2)

        }
        binding.option3.setOnClickListener {
            optionclick(3)
        }
        binding.option4.setOnClickListener {
            optionclick(4)
        }

        binding.submit.setOnClickListener {
            if (binding.submit.text == "FINISH") {
                val intent = Intent(this, Result::class.java)
                intent.putExtra("correct_answer", mCorrectanswer)
                startActivity(intent)
                finish()
            }
            else if (binding.submit.text == "GO TO NEXT QUESTION") {
                mSelectedOptionPosition=0
                mCurrentpos++
                setquestion()
                binding.submit.text = "SUBMIT"
            } else {
                if (mSelectedOptionPosition == 0) { // no option is selected
                    Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()

                } else { //an option is selected
                    val questionno = mQuestionList!![mCurrentpos - 1]
                    val correctanswer = questionno.correctAnswer
                    if (correctanswer != mSelectedOptionPosition) {
                        if (mSelectedOptionPosition == 1) {
                            binding.option1.background =
                                ContextCompat.getDrawable(this, R.drawable.submit_select_incorrect)
                        }
                        if (mSelectedOptionPosition == 2) {
                            binding.option2.background =
                                ContextCompat.getDrawable(this, R.drawable.submit_select_incorrect)
                        }
                        if (mSelectedOptionPosition == 3) {
                            binding.option3.background =
                                ContextCompat.getDrawable(this, R.drawable.submit_select_incorrect)

                        }
                        if (mSelectedOptionPosition == 4) {
                            binding.option4.background =
                                ContextCompat.getDrawable(this, R.drawable.submit_select_incorrect)
                        }

                    }
                    // set green color for right option
                    if (correctanswer == 1) {
                        binding.option1.background =
                            ContextCompat.getDrawable(this, R.drawable.submit_select_correct)
                    }
                    if (correctanswer == 2) {
                        binding.option2.background =
                            ContextCompat.getDrawable(this, R.drawable.submit_select_correct)
                    }
                    if (correctanswer == 3) {
                        binding.option3.background =
                            ContextCompat.getDrawable(this, R.drawable.submit_select_correct)

                    }
                    if (correctanswer == 4) {
                        binding.option4.background =
                            ContextCompat.getDrawable(this, R.drawable.submit_select_correct)
                    }

                    if (mSelectedOptionPosition==correctanswer){
                        mCorrectanswer++
                        Log.d("correctanswer",mCorrectanswer.toString())
                    }
                    if (mCurrentpos <= mQuestionList!!.size) {
                        if(mCurrentpos == mQuestionList!!.size)
                        {
                            binding.submit.text = "FINISH"
                        }
                        if(mCurrentpos != mQuestionList!!.size){
                            binding.submit.text = "GO TO NEXT QUESTION"
                         }
                        mSelectedOptionPosition = 0
                        Log.d("mCurrentpos",mCurrentpos.toString())
                        Log.d("mQuestionList",mQuestionList!!.size.toString())
                       }
                }


            }
        }

    }


    fun setquestion() {
        val questionset: QuestionModel = mQuestionList!!.get(mCurrentpos - 1)

        defaultOptionView()

        binding.progressbar.progress = mCurrentpos
        binding.progressNo.text = "$mCurrentpos" + "/" + "${binding.progressbar.max}"

        binding.question.text = questionset.question
        binding.option1.text = questionset.option1
        binding.option2.text = questionset.option2
        binding.option3.text = questionset.option3
        binding.option4.text = questionset.option4




    }

    fun defaultOptionView() {
        val optionlist = ArrayList<TextView>()
        optionlist.add(0, binding.option1)
        optionlist.add(1, binding.option2)
        optionlist.add(2, binding.option3)
        optionlist.add(3, binding.option4)

        for (option in optionlist) {
            option.setTextColor(Color.parseColor("#363A43"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.optionboxshape)
        }
    }
    fun optionclick(y:Int){
        defaultOptionView()
        mSelectedOptionPosition = y
        if (y == 1) {
            binding.option1.setTextColor(Color.parseColor("#363A43"))
            binding.option1.setTypeface(binding.option1.typeface, Typeface.BOLD)
            binding.option1.background = ContextCompat.getDrawable(this, R.drawable.select_option_border)
        }
        if (y == 2) {
            binding.option2.setTextColor(Color.parseColor("#363A43"))
            binding.option2.setTypeface(binding.option1.typeface, Typeface.BOLD)
            binding.option2.background = ContextCompat.getDrawable(this, R.drawable.select_option_border)
        }
        if (y == 3) {
            binding.option3.setTextColor(Color.parseColor("#363A43"))
            binding.option3.setTypeface(binding.option1.typeface, Typeface.BOLD)
            binding.option3.background = ContextCompat.getDrawable(this, R.drawable.select_option_border)
        }
        if (y == 4) {
            binding.option4.setTextColor(Color.parseColor("#363A43"))
            binding.option4.setTypeface(binding.option1.typeface, Typeface.BOLD)
            binding.option4.background = ContextCompat.getDrawable(this, R.drawable.select_option_border)
        }
    }
}

