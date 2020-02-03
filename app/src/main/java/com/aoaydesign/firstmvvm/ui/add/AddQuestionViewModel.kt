package com.aoaydesign.firstmvvm.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.aoaydesign.firstmvvm.model.Question

class AddQuestionViewModel(application: Application):AndroidViewModel(application)  {
    private val repository:AddQuestionRepository by lazy { AddQuestionRepository(application) }

    fun insert(question: Question)=repository.insertQuestion(question)


}