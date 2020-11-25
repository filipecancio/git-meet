package com.example.gitmeet.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gitmeet.R
import com.example.gitmeet.model.Repo
import com.example.gitmeet.ui.RepoDetailActivity

class ReposAdapter(
    private val context: Context,
    private val list: List<Repo>
) : RecyclerView.Adapter<ReposAdapter.RepoVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_repos, parent, false)
        return RepoVH(view)
    }

    override fun onBindViewHolder(holder: RepoVH, position: Int) {
        val repo = list[position]
        Glide.with(holder.itemView).load(repo.owner.avatarUrl).into(holder.itemView.findViewById(R.id.repoid1))
        holder.itemView.findViewById<TextView>(R.id.txt_name).text = repo.name
        holder.itemView.findViewById<TextView>(R.id.txt_user).text = repo.owner.login
        holder.itemView.setOnClickListener {
            context.startActivity(RepoDetailActivity.getStartIntent(context, repo))
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class RepoVH(view: View) : RecyclerView.ViewHolder(view)

}