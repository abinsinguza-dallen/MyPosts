package com.ron.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ron.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }
    fun fetchPosts(){
        val apiClient=API_client.buildAPI_client(ApiInterface::class.java)
        var request=apiClient.getposts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    Toast
                        .makeText(baseContext, "fetched${post!!.size} Post", Toast.LENGTH_LONG).show()

           var adaptor=postsRvAdaptor(baseContext,post)
                    Log.d("Tag",fetchPosts().toString())
                    binding.rvPosts.adapter=adaptor
                    binding.rvPosts.layoutManager=LinearLayoutManager(baseContext)
                }
            }




            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

        })
    }

    }
