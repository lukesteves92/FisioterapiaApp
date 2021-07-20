package com.lucasesteves.fisioterapiaapp.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lucasesteves.fisioterapiaapp.R
import com.lucasesteves.fisioterapiaapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private var binding: FragmentSplashBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.loginButton?.setOnClickListener{

            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }

        binding?.registrarButton?.setOnClickListener{

            findNavController().navigate(R.id.action_splashFragment_to_cadastrarFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}