package com.example.dec2021.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.dec2021.R
import com.example.dec2021.ViewModel.ApiListViewModel
import com.example.dec2021.databinding.FragmentApiFormBinding


class ApiFormFragment : Fragment() {
    lateinit var binding: FragmentApiFormBinding
    val viewModel: ApiListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentApiFormBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonCreate.setOnClickListener {

            val body = binding.editTextBody.text.toString()
            val title = binding.editTextTitle.text.toString()
            viewModel.requestPost(body, title)
        }

    }



}