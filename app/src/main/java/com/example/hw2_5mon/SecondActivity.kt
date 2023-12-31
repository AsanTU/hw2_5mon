package com.example.hw2_5mon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw2_5mon.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = intent.getStringExtra("firstName")
        val secondName = intent.getStringExtra("secondName")
        val percentage = intent.getStringExtra("percentage")
        val result = intent.getStringExtra("result")
        binding.resTv.text = "Result for $firstName and $secondName: $percentage - $result"
    }
}
