package com.example.hw2_5mon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw2_5mon.databinding.ActivityMainBinding
import com.example.hw2_5mon.model.LoveModel
import com.example.hw2_5mon.model.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getBtn.setOnClickListener {
            val firstName = binding.firstEd.text.toString()
            val secondName = binding.secondEd.text.toString()

            if (firstName.isNotEmpty() && secondName.isNotEmpty()) {
                initClickers(firstName, secondName)
            }
        }
    }

    private fun initClickers(firstName: String, secondName : String) {
        val loveApi = RetrofitService().api

        loveApi.getLovePerc(firstName, secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    val loveModel = response.body()
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("firstName", firstName)
                    intent.putExtra("secondName", secondName)
                    intent.putExtra("percentage", loveModel?.percentage)
                    intent.putExtra("result", loveModel?.result)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
            }
        })
    }
}

