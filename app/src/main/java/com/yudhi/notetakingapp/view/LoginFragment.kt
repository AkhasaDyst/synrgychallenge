package com.yudhi.notetakingapp.view

import android.accounts.AccountManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yudhi.notetakingapp.R
import com.yudhi.notetakingapp.databinding.FragmentHomeBinding
import com.yudhi.notetakingapp.databinding.FragmentLoginBinding
import com.yudhi.notetakingapp.model.NotesAdapter
import com.yudhi.notetakingapp.model.SharedPreference
import com.yudhi.notetakingapp.viewmodel.NoteViewModel


class LoginFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val usernameEditText = binding.etUsername.editText
        val passwordEditText = binding.etPassword.editText

        binding.btnLogin.setOnClickListener {
            val enteredUsername = usernameEditText?.text.toString()
            val enteredPassword = passwordEditText?.text.toString()
            val loggedIn = loginUser(requireContext(), enteredUsername, enteredPassword)

            if (loggedIn) {
                // Navigate to the next screen after successful login
                view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                Toast.makeText(requireContext(), "INVALID LOGIN", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvAkun.setOnClickListener{
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    fun loginUser(context: Context, enteredUsername: String, enteredPassword: String): Boolean {
        val (savedUsername, savedPassword) = SharedPreference.getSavedAccount(context)
        return savedUsername == enteredUsername && savedPassword == enteredPassword
    }

}


