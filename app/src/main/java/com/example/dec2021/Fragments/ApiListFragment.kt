package com.example.dec2021.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dec2021.Adapters.ApiAdapter
import com.example.dec2021.R
import com.example.dec2021.ViewModel.ApiListViewModel
import com.example.dec2021.databinding.FragmentApiListBinding


class ApiListFragment : Fragment() {

    lateinit var binding: FragmentApiListBinding
    val viewModel: ApiListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApiListBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter : ApiAdapter = ApiAdapter()
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(requireContext())

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = linearLayoutManager

        viewModel.load()
        viewModel.apiLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        binding.fabMy.setOnClickListener {
            findNavController().navigate(R.id.action_apiListFragment_to_apiFormFragment)
        }
    }


}