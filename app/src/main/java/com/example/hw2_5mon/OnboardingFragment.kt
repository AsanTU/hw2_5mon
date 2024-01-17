package com.example.hw2_5mon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw2_5mon.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(ARG_TITLE)?:""
        val description = arguments?.getString(ARG_DESCRIPTION)?:""

        binding.nameTv.text = title
        binding.descTv.text = description
    }

    companion object{
        private const val ARG_TITLE = "arg_title"
        private const val ARG_DESCRIPTION = "arg_description"

        fun newInstance(title: String, description: String): OnboardingFragment{
            val fragment = OnboardingFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_DESCRIPTION, description)
            fragment.arguments = args
            return fragment
        }
    }
}