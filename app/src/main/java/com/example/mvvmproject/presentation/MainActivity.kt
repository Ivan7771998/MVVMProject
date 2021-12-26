package com.example.mvvmproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.R
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var savedData: TextView
    private lateinit var inputData: EditText
    private lateinit var btnGetData: MaterialButton
    private lateinit var btnSendData: MaterialButton

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("TAG", "Activity created")

        initView()

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        vm.resultLiveData.observe(this, { text ->
            savedData.text = text
        })

        btnSendData.setOnClickListener {
            val text = inputData.text.toString()
            vm.save(text = text)
        }

        btnGetData.setOnClickListener {
            vm.load()
        }
    }

    private fun initView() {
        savedData = findViewById(R.id.str_text_view)
        inputData = findViewById(R.id.input_data)
        btnGetData = findViewById(R.id.btn_get_data)
        btnSendData = findViewById(R.id.btn_send_data)
    }
}