package com.example.hw2_5mon
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferenceModule(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("onboarding", Context.MODE_PRIVATE)

    fun isOnboardingCompleted(): Boolean {
        return sharedPreferences.getBoolean("onboarding_completed", false)
    }

    fun setOnboardingCompleted(completed: Boolean) {
        sharedPreferences.edit {
            putBoolean("onboarding_completed", completed)
        }
    }
}
