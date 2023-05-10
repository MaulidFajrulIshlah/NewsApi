package com.geminiboy.latihan2navcom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geminiboy.latihan2navcom.R
import com.geminiboy.latihan2navcom.databinding.FragmentProfilBinding


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfilBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfilBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dapatInput = arguments?.getString("home")
        binding.textView.setText(dapatInput)

    }

}