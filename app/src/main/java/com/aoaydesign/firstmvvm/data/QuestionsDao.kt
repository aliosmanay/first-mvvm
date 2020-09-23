package com.aoaydesign.firstmvvm.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aoaydesign.firstmvvm.model.Question

@Dao
interface QuestionsDao {

    @Query("SELECT * FROM questions")
    fun getQuestions(): LiveData<List<Question>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuestion(question: Question)


    @Query("DELETE FROM  questions")
    fun deleteALL()

}