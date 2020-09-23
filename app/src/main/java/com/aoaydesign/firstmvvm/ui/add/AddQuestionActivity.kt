package com.aoaydesign.firstmvvm.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.ViewModelProviders
import com.aoaydesign.firstmvvm.R
import com.aoaydesign.firstmvvm.model.Question
import kotlinx.android.synthetic.main.activity_add_question.*

class AddQuestionActivity : AppCompatActivity() {

    private lateinit var viewModel: AddQuestionViewModel
    private lateinit var answer: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)

        viewModel = ViewModelProviders.of(this).get(AddQuestionViewModel::class.java)

        prepareSpinner()
        save_btn.setOnClickListener {
            val question = question_edt.text.toString()
            val optionA = option_a_edt.text.toString()
            val optionB = option_b_edt.text.toString()
            val optionC = option_c_edt.text.toString()

            viewModel.insert(
                Question(
                    question = question,
                    optionA = optionA,
                    optionB = optionB,
                    optionC = optionC,
                    answer = if (answer == "A") optionA else if (answer == "B") optionB else optionC
                )
            )

            Toast.makeText(this, "Ekleme Basarili", Toast.LENGTH_SHORT).show()

        }

    }

    private fun prepareSpinner() {
        val optList = mutableListOf("A", "B", "C")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, optList)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                answer = parent?.getItemAtPosition(position).toString()

            }

        }

    }


}
