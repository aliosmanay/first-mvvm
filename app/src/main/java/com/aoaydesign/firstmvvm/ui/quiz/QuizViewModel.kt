package com.aoaydesign.firstmvvm.ui.quiz

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.aoaydesign.firstmvvm.model.Question

class QuizViewModel(application: Application) : AndroidViewModel(application) {
    private val repository:QuizRepository by lazy { QuizRepository(application) }
    val allQuestions:LiveData<List<Question>> by lazy { repository.getAllQuestions() }
}