package com.example.hw2_5mon

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.viewpager2.widget.ViewPager2
import com.example.hw2_5mon.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var sharedPreferenceModule: SharedPreferenceModule
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferenceModule = SharedPreferenceModule(this)
        if (!sharedPreferenceModule.isOnboardingCompleted()){
            setupOnboarding()
        } else{
            startMainActivity()
        }
    }

    private fun setupOnboarding() {
        val adapter = OnboardingAdapter(this)
        binding.viewPager.adapter = adapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                val slides = adapter.getSlides()
                if (position == slides.size - 1){
                    sharedPreferenceModule.setOnboardingCompleted(true)
                    startMainActivity()
                }
            }
        })
    }

    private fun startMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}