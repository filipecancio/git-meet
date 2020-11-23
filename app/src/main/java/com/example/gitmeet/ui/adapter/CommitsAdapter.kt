package com.example.gitmeet.ui.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gitmeet.R
import com.example.gitmeet.model.Commit

class CommitsAdapter(
    private val context:Context,
    private val list:List<Commit>
) : RecyclerView.Adapter<CommitsAdapter.CommitVH>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_commits,parent,false)
        return CommitVH(view)
    }

    override fun onBindViewHolder(holder: CommitVH, position: Int) {
        val commit = list[position]
        Glide.with(holder.itemView).load(commit.owner.avatarUrl).into(holder.itemView.findViewById(R.id.commit_img))
        holder.itemView.findViewById<TextView>(R.id.commit_message).text = commit.message
        holder.itemView.findViewById<TextView>(R.id.commit_hash).text = commit.hash
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class CommitVH(view: View):RecyclerView.ViewHolder(view)
}
