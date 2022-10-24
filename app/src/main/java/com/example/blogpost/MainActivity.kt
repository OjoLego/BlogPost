package com.example.blogpost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blogpost.databinding.ActivityMainBinding
import com.example.blogpost.model.data.PostResult
import com.example.blogpost.view.adapter.PostAdapter
import com.example.blogpost.view.adapter.PostClickListener
import com.example.blogpost.view.screen.CommentsActivity
import com.example.blogpost.view.screen.SendPostFragment
import com.example.blogpost.viewmodel.MainViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

//    companion object{
//        val INTENT_PARCELABLE = "OBJECT_INTENT"
//    }

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var postAdapter: PostAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel.getBlockPost()
//        initRecyclerView()
        observeViewModel()
        toCreatePost()
    }

    private fun initRecyclerView(list: List<PostResult> = emptyList()) {
        binding.mainActivityRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            postAdapter = PostAdapter(list, object : PostClickListener {
                override fun onPostClick(id: Int, postTitle:String, postBody:String) {
                    val intent = Intent(this@MainActivity, CommentsActivity::class.java)
                    intent.putExtra("postId", id)
                    intent.putExtra("postBody",postBody)
                    intent.putExtra("postTitle", postTitle)
//                    intent.putExtra(INTENT_PARCELABLE,id)
                    startActivity(intent)
                }
            })
            adapter = postAdapter
//            mainViewModel.getBlockPost()
        }
    }

    private fun observeViewModel() {
        mainViewModel.postList.observe(this) {
            initRecyclerView(it)
        }
    }

    private fun toCreatePost() {
        binding.addPost.setOnClickListener {
            var dialog = SendPostFragment()
            dialog.show(supportFragmentManager,"sendPostFragment")
    }
  }
}