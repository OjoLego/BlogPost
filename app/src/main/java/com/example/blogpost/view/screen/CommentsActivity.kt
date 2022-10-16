package com.example.blogpost.view.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blogpost.R
import com.example.blogpost.databinding.ActivityCommentsBinding
import com.example.blogpost.model.data.CommentsResult
import com.example.blogpost.view.adapter.CommentsAdapter
import com.example.blogpost.viewmodel.MainViewModel


private const val TAG = "CommentsActivity"
class CommentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommentsBinding
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var commentsAdapter: CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel.getComments(intent.getIntExtra("postId",0).toString())
        observeViewModel2()
    }

    private fun initRecyclerView2(list: List<CommentsResult> = emptyList()){
        binding.commentsActivityRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CommentsActivity)
            commentsAdapter = CommentsAdapter(list)
            adapter = commentsAdapter
        }
    }

    private fun observeViewModel2(){
        mainViewModel.commentsList.observe(this){
            initRecyclerView2(it)
        }
    }
}