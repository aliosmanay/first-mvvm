package com.aoaydesign.firstmvvm.ui.result

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aoaydesign.firstmvvm.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        intent.extras.let {
            val result = intent.extras?.getInt("score")
            val listSize = intent.extras?.getInt("arraySize")
            Toast.makeText(this,"tamamlandi",Toast.LENGTH_SHORT).show()
            result_tv.text="${listSize} sorudan ${result} tanesini dogru bildiniz"

        }


    }
}
