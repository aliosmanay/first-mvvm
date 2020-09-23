package com.aoaydesign.firstmvvm.ui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.aoaydesign.firstmvvm.R
import com.aoaydesign.firstmvvm.model.Question
import com.aoaydesign.firstmvvm.ui.result.ResultActivity
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var viewModel: QuizViewModel
    private var questionList: List<Question> = arrayListOf()
    private var qIndex: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        viewModel = ViewModelProviders.of(this).get(QuizViewModel::class.java)

        viewModel.allQuestions.observe(this, Observer {

            if (it.isNotEmpty()) {
                questionList = it
                setViews()
                next_btn.setOnClickListener {
                    val answer = findViewById<Chip>(chip_group.checkedChipId)

                    chip_group.clearCheck()

                    checkAnswer(answer)

                    qIndex++

                    if (qIndex < questionList.size) setViews()
                    else {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("score", score)
                        intent.putExtra("arraySize", questionList.size)
                        startActivity(intent)
                        finish()
                    }

                }
            }
        })

    }

    private fun setViews() {
        tv_question.text = questionList[qIndex].question
        option_a_chip.text = questionList[qIndex].optionA
        option_b_chip.text = questionList[qIndex].optionB
        option_c_chip.text = questionList[qIndex].optionC
    }

    private fun checkAnswer(answer: Chip) {
        if (questionList[qIndex].answer == answer.text) {
            Toast.makeText(this, "Dogru Cevap", Toast.LENGTH_SHORT).show()
            score++
        } else {
            Toast.makeText(
                this,
                "Yanlis Cevap \n Cevap= ${questionList[qIndex].answer} ",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}
