package com.ron.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ron.myposts.databinding.ListPostsBinding

class postsRvAdaptor (var context: Context, var postList:List<Post>):RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var bindingView = ListPostsBinding.inflate(LayoutInflater.from(context), parent, false)
        return PostsViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var currentItem = postList.get(position)
         with(holder.binding){
             tvuserId.text=currentItem.userId.toString()
             tvId.text=currentItem.id.toString()
             tvtitle.text=currentItem.title
             tvbody.text=currentItem.body

        }
    }
        override fun getItemCount(): Int {
            return postList.size
        }


}
class PostsViewHolder(var binding: ListPostsBinding):RecyclerView.ViewHolder(binding.root)




