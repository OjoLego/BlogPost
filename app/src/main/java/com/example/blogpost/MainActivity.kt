package com.example.blogpost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blogpost.databinding.ActivityMainBinding
import com.example.blogpost.model.data.PostResult
import com.example.blogpost.view.adapter.PostAdapter
import com.example.blogpost.view.adapter.PostClickListener
import com.example.blogpost.view.screen.CommentsActivity
import com.example.blogpost.view.screen.SendPostFragment
import com.example.blogpost.viewmodel.MainViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), PostClickListener {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

//    private lateinit var postAdapter: PostAdapter

    private lateinit var itemList: MutableList<PostResult>

    var postAdapter = PostAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel.getBlockPost()
        mainViewModel.getPostUser()
        initRecyclerView()
//        observeViewModel()
        observeViewModelPost()
        observeViewModelUser()
        toCreatePost()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        val menuItem = menu!!.findItem(R.id.searchView)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
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

    private fun initRecyclerView(
//        list: MutableList<PostResult>
    ) {
        binding.mainActivityRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
//            postAdapter = PostAdapter(list,object : PostClickListener {
//                override fun onPostClick(id: Int, postTitle:String, postBody:String) {
//                    val intent = Intent(this@MainActivity, CommentsActivity::class.java)
//                    intent.putExtra("postId", id)
//                    intent.putExtra("postBody", postBody)
//                    intent.putExtra("postTitle", postTitle)
//
//                    startActivity(intent)
//                }
//            })
            adapter = postAdapter
//            itemList = list
        }
    }

    private fun observeViewModelPost(){
        mainViewModel.postList.observe(this){
            postAdapter.setPostData(it.toMutableList())
        }
    }

    private fun observeViewModelUser(){
        mainViewModel.getPostUser.observe(this){
            postAdapter.setPostUserData(it.toMutableList())
        }
    }

//    private fun observeViewModel() {
//        mainViewModel.postList.observe(this) {
//            initRecyclerView(
//                it.toMutableList()
//            )
//        }
//    }

    private fun toCreatePost() {
        binding.addPost.setOnClickListener {
            var dialog = SendPostFragment()
            dialog.show(supportFragmentManager,"sendPostFragment")
    }
  }

    private fun filterSearch(searchWord: String){
        var filterList = mutableListOf<PostResult>()
        filterList = itemList.filter { it.body!!.contains(searchWord) || it.title!!.contains(searchWord) }.toMutableList()
        postAdapter.setPostData(filterList)
    }

    override fun onPostClick(
        id: Int,
        postTitle: String,
        postBody: String,
        postUserName: String,
        view: View
    ) {
        val intent = Intent(this@MainActivity, CommentsActivity::class.java)
                    intent.putExtra("postId", id)
                    intent.putExtra("postBody", postBody)
                    intent.putExtra("postTitle", postTitle)
                    intent.putExtra("postUserName", postUserName)

                    startActivity(intent)
    }

}