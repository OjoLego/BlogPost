package com.example.blogpost.view.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blogpost.R
import com.example.blogpost.databinding.ActivityCommentsBinding
import com.example.blogpost.model.data.CommentsResult
import com.example.blogpost.view.adapter.CommentsAdapter
import com.example.blogpost.view.adapter.CommentsViewHolder
import com.example.blogpost.viewmodel.CommentsViewModel


private const val TAG = "CommentsActivity"
class CommentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommentsBinding
    private val commentsViewModel: CommentsViewModel by viewModels()

    var commentsAdapter = CommentsAdapter()

    private lateinit var itemListComments: MutableList<CommentsResult>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        commentsViewModel.addBulkComments(intent.getIntExtra("postId",0).toString())
        initRecyclerView2()
        observeViewModel2()

        val bundle: Bundle?= intent.extras
        val postTitle = bundle!!.getString("postTitle")
        val postBody = bundle!!.getString("postBody")
//        val postId = bundle!!.getInt("postId").toString()
//        val postUser = bundle!!.getString("postUser")
        val postUserName = bundle!!.getString("postUserName")


        binding.postCommentTitle.text = postTitle
        binding.postCommentBody.text = postBody
        binding.authoursNameComments.text = postUserName
//        binding.postCommentUserId.text = postId

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_comments,menu)
        val menuItem = menu!!.findItem(R.id.searchViewComments)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                filterSearch(filterString!!)
                return true
            }

            override fun onQueryTextChange(filterString: String?): Boolean {
                Log.d("QUERY",filterString.toString())
                filterSearch(filterString!!)
                return true
            }

        })
        return true
    }

    private fun filterSearch(searchWord: String) {
        var filterList = mutableListOf<CommentsResult>()
        filterList = itemListComments.filter { it.body!!.contains(searchWord) || it.email!!.contains(searchWord)}.toMutableList()
        commentsAdapter.setCommentsResult(filterList)
    }

    private fun initRecyclerView2(
//        list: MutableList<CommentsResult>
    ){
        binding.commentsActivityRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CommentsActivity)
//            commentsAdapter = CommentsAdapter()
            adapter = commentsAdapter
        }
    }

    private fun observeViewModel2(){
        commentsViewModel.readAllCommentsResult.observe(this){
            itemListComments = it.toMutableList()
            commentsAdapter.setCommentsResult(it.toMutableList())
        }
    }
}