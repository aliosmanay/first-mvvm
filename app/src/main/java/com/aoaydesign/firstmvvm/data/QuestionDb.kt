package com.aoaydesign.firstmvvm.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aoaydesign.firstmvvm.model.Question

@Database(entities = arrayOf(Question::class), version = 1)
abstract class QuestionDb : RoomDatabase() {
    abstract fun questionDao(): QuestionsDao

    companion object {
        @Volatile
        var INSTANCE: QuestionDb? = null

        @Synchronized
        fun getInstance(context: Context): QuestionDb {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDb::class.java,
                    "question_db"
                )
                    .addCallback(roomDBCallback)
                    .build()
            }

            return INSTANCE as QuestionDb
        }

        private val roomDBCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsynTask(INSTANCE).execute()

            }
        }

        class PopulateAsynTask(private val db: QuestionDb?) : AsyncTask<Void, Void, Void>() {
            private val dao: QuestionsDao? by lazy { db?.questionDao() }

            override fun doInBackground(vararg params: Void?): Void? {
                var question = Question(
                    question = "Turkiye liginde en cok sampiyon olan takim hangisidir?",
                    optionA = "Fenerbahce",
                    optionB = "Galatasaray",
                    optionC = "Besiktas",
                    answer = "Galatasaray"
                )
                dao?.addQuestion(question)

                question = Question(
                    question = "Turkiye liginde en cok sampiyon olan basketbol takim hangisidir?",
                    optionA = "Fenerbahce",
                    optionB = "Galatasaray",
                    optionC = "Anadolu Efes",
                    answer = "Anadolu Efes"
                )
                dao?.addQuestion(question)

                question = Question(
                    question = "Turkiye Kupasinda en cok sampiyon olan takim hangisidir?",
                    optionA = "Fenerbahce",
                    optionB = "Galatasaray",
                    optionC = "Besiktas",
                    answer = "Galatasaray"
                )
                dao?.addQuestion(question)


                return null
            }
        }

    }

}