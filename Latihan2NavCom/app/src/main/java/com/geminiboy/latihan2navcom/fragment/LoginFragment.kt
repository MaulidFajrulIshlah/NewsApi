package com.geminiboy.latihan2navcom.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geminiboy.latihan2navcom.R
import com.geminiboy.latihan2navcom.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginbtn.setOnClickListener{
            val usern = binding.editText.text.toString()
            val bund = Bundle()
            bund.putString("username", usern)
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bund)
        }
        binding.signup.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }

}