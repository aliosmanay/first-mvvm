package com.aoaydesign.firstmvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true)
    var qid:Int=0,

    var question :String ,

    @ColumnInfo(name = "option_a")
    var optionA : String,

    @ColumnInfo(name = "option_b")
    var optionB : String,

    @ColumnInfo(name = "option_c")
    var optionC : String,

    var answer : String


)