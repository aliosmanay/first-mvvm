package com.aoaydesign.firstmvvm.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aoaydesign.firstmvvm.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        intent.extras.let {
            val result = intent.extras?.getInt("score")
            val listSize = intent.extras?.getInt("arraySize")
            result_tv.text="${listSize} sorudan ${result} tanesini dogru bildiniz"

        }


    }
}
