package edu.itvo.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import dagger.hilt.android.AndroidEntryPoint
import edu.itvo.quotescelebrities.databinding.FragmentLoginBinding

import edu.itvo.quotescelebrities.presentation.viewmodel.LoginViewModel


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding:  FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    private fun observer(){

    }

}