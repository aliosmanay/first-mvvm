package com.aoaydesign.firstmvvm.ui.add

import android.content.Context
import android.os.AsyncTask
import com.aoaydesign.firstmvvm.data.QuestionDb
import com.aoaydesign.firstmvvm.data.QuestionsDao
import com.aoaydesign.firstmvvm.model.Question

class AddQuestionRepository(context: Context) {

    private val db: QuestionDb by lazy { QuestionDb.getInstance(context) }
    private val dao: QuestionsDao by lazy { db.questionDao() }

    fun insertQuestion(question: Question) {

        InsertAsynTask(dao).execute(question)

    }


    private class InsertAsynTask(val dao: QuestionsDao) : AsyncTask<Question, Void, Void>() {
        override fun doInBackground(vararg params: Question?): Void? {

            dao.addQuestion(params[0]!!)
            return null
        }

    }

}