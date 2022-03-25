package com.kg.geektech.homework1_month61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kg.geektech.homework1_month61.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val keyEdit: String = "name"
        const val keyResult: String = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etTextS.setText(intent.getStringExtra(keyEdit))

        binding.btnSend.setOnClickListener {
            setResult(RESULT_OK,Intent().putExtra(keyResult,
                binding.etTextS.text.toString() ))
            finish()
        }
    }
}