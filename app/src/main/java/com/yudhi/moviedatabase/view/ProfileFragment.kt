package com.yudhi.moviedatabase.view

import android.accounts.AccountManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.yudhi.moviedatabase.R
import com.yudhi.moviedatabase.databinding.FragmentProfileBinding
import com.yudhi.moviedatabase.databinding.FragmentRegisterBinding
import com.yudhi.moviedatabase.helper.MyDataStore
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEditText = binding.etUsername.editText
        val passwordEditText = binding.etPassword.editText
        val passwordEditText2 = binding.etPassword2.editText
        val emailEditText = binding.etEmail.editText
        viewLifecycleOwner.lifecycleScope.launch {
            MyDataStore.getSavedAccount(requireContext()).collect { (username, password, email) ->
                usernameEditText?.setText(username)
                passwordEditText?.setText(password)
                passwordEditText2?.setText(password)
                emailEditText?.setText(email)
            }
        }
        binding.btnUpdate.setOnClickListener {
            val enteredUsername = usernameEditText?.text.toString()
            val enteredPassword = passwordEditText?.text.toString()
            val enteredPassword2 = passwordEditText2?.text.toString()
            val enteredEmail = emailEditText?.text.toString()

            // Perform some validation here if needed
            if (enteredPassword == enteredPassword2) {
                // Save the account information
                lifecycleScope.launch {
                    MyDataStore.saveAccount(requireContext(), enteredUsername, enteredPassword, enteredEmail)
                }

            } else {
                Toast.makeText(requireContext(), "WRONG PASSWORD", Toast.LENGTH_SHORT).show()
            }
            view.findNavController().navigate(R.id.action_profileFragment_to_movieFragment)

        }

        binding.btnLogout.setOnClickListener{
            //SharedPreference.clearAccount(requireContext())
            view.findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }

    }
}