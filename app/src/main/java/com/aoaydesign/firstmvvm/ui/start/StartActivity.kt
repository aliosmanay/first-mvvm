package com.aoaydesign.firstmvvm.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aoaydesign.firstmvvm.R
import com.aoaydesign.firstmvvm.ui.add.AddQuestionActivity
import com.aoaydesign.firstmvvm.ui.quiz.QuizActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startQuiz.setOnClickListener {
            startActivity(Intent(this,QuizActivity::class.java))
            finish()
        }


        addQuestions.setOnClickListener {
            startActivity(Intent(this,AddQuestionActivity::class.java))
        }

    }
}
