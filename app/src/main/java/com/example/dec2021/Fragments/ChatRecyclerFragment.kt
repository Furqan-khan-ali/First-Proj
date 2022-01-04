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
import androidx.recyclerview.widget.RecyclerView
import com.example.dec2021.Adapters.ChatAdapter
import com.example.dec2021.Adapters.ChatUIModel
import com.example.dec2021.R
import com.example.dec2021.ViewModel.ChatViewModel
import com.example.dec2021.databinding.FragmentChatRecyclerBinding


class ChatRecyclerFragment : Fragment() {

    lateinit var binding: FragmentChatRecyclerBinding
    val viewModel: ChatViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentChatRecyclerBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
        val adpater: ChatAdapter = ChatAdapter(itemClickListner = {
            bundle.putString("msg",it.text)
            findNavController().navigate(R.id.action_chatRecyclerFragment_to_itemClickFragment)
        })
        val linearLayOut = LinearLayoutManager(requireContext())

        binding.recyclerView.adapter=adpater
        binding.recyclerView.layoutManager=linearLayOut

        viewModel.chatLiveData.observe(viewLifecycleOwner){
         adpater.submitList(it)
        }



        binding.fabMy.setOnClickListener {
            val text = binding.editTextMessage.text.toString()
            viewModel.myChat(text = text)
        }

        binding.fabOther.setOnClickListener {
            val text = binding.editTextMessage.text.toString()
            viewModel.otherChat(text = text)
        }

    }


}