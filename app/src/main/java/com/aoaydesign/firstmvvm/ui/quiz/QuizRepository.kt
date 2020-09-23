package com.aoaydesign.firstmvvm.ui.quiz

import android.content.Context
import androidx.lifecycle.LiveData
import com.aoaydesign.firstmvvm.data.QuestionDb
import com.aoaydesign.firstmvvm.data.QuestionsDao
import com.aoaydesign.firstmvvm.model.Question

class QuizRepository(contex: Context) {

    private val db: QuestionDb by lazy { QuestionDb.getInstance(contex) }
    private val dao: QuestionsDao by lazy { db.questionDao() }

    fun getAllQuestions(): LiveData<List<Question>> = dao.getQuestions()
}