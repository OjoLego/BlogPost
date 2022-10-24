package com.example.blogpost.view.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.blogpost.R
import com.example.blogpost.databinding.FragmentSendPostBinding
import com.example.blogpost.model.data.SendPostData
import com.example.blogpost.model.data.SendPostResult
import com.example.blogpost.viewmodel.MainViewModel

private const val TAG = "SendPostFragment"
class SendPostFragment : DialogFragment() {

    private var _binding: FragmentSendPostBinding? = null
    private val binding get() = _binding!!
    lateinit var Viewmodel: MainViewModel
    lateinit var params: SendPostData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSendPostBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        binding.addPostBtn.setOnClickListener {
            createPost()
        }
    }

    private fun initViewModel() {
        Viewmodel = ViewModelProvider(this)[MainViewModel::class.java]
        Viewmodel.sendPostt.observe(this, Observer<SendPostResult> {
            Log.d(TAG,"Reach here")
            if (it == null) {
//                binding.sendPostBody.visibility = View.GONE
                Log.d(TAG,"FAILED TO CREATE POST")
             Toast.makeText(requireActivity(),"Failed to create post", Toast.LENGTH_LONG).show()
            }else{
//                binding.addPostBtn.visibility = View.GONE
                Log.d(TAG,"SUCCESSFUL!!")
                Toast.makeText(requireActivity(),"Successful", Toast.LENGTH_LONG).show()
                dismiss()
            }
        })
    }

    private fun createPost() {
        val sendPostData = SendPostData(binding.sendPostBody.text.toString(),
            binding.sendPostTitle.text.toString(),
            binding.sendPostId.text.toString().toInt()
        )
        Viewmodel.sendPost(sendPostData)
    }
}