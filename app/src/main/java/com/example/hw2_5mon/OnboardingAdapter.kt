package com.example.hw2_5mon

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    private val onboardingSlides = listOf(
        OnboardingFragment.newInstance("Title 1", "Desc 1"),
        OnboardingFragment.newInstance("Title 2", "Desc 2"),
        OnboardingFragment.newInstance("Title 3", "Desc 3"),
        OnboardingFragment.newInstance("Title 4", "Desc 4")
    )

    override fun getItemCount(): Int = onboardingSlides.size
    override fun createFragment(position: Int): Fragment {
        return onboardingSlides[position]
    }

    fun getSlides(): List<OnboardingFragment>{
        return onboardingSlides
    }

}