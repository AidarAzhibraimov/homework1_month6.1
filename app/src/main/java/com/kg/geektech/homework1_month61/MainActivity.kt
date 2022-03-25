package com.kg.geektech.homework1_month61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.kg.geektech.homework1_month61.databinding.ActivityMainBinding
import com.kg.geektech.homework1_month61.extansions.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    companion object {
        const val keyEdit: String = "name"
        const val keyResult: String = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            if (binding.etTextM.text.toString().isEmpty()) {
                showToast(getString(R.string.NoText))
            } else {
                Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra(keyEdit, binding.etTextM.text.toString())
                    registerForActivityResult.launch(this)
                }
            }
        }

        registerForActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            binding.etTextM.setText(result.data?.getStringExtra(keyResult))
        }
    }

}