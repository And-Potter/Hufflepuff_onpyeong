package com.example.androidseminar.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidseminar.data.RepoInfo
import com.example.androidseminar.databinding.ItemRepoBinding

class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> () {

    val repoList = mutableListOf<RepoInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepoViewHolder(binding)
    }

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    class RepoViewHolder(
            private val binding: ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(repoInfo: RepoInfo) {
            binding.tvRepoName.text = repoInfo.repoName
            binding.tvRepoDisc.text = repoInfo.repoDisc
            binding.tvRepoLanguage.text = repoInfo.repoLanguage
        }
    }

}