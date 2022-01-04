package com.example.dec2021.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dec2021.R
import com.example.dec2021.databinding.FragmentItemClickBinding


class ItemClickFragment : Fragment() {
    lateinit var binding: FragmentItemClickBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentItemClickBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val msg = arguments?.getString("msg")
            binding.editTextClickMsg.setText(msg)
        }
    }


}