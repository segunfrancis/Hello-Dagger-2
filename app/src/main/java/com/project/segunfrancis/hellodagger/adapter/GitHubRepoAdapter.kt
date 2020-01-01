package com.project.segunfrancis.hellodagger.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.project.segunfrancis.hellodagger.R
import com.project.segunfrancis.hellodagger.data.GitHubRepo
import kotlinx.android.synthetic.main.item_github_repo.view.*
import kotlin.collections.ArrayList

class GitHubRepoAdapter :
    RecyclerView.Adapter<GitHubRepoAdapter.GitHubRepoViewHolder>() {
    private var gitHubRepos = ArrayList<GitHubRepo>()
    //private var gitHubRepos: List<GitHubRepo> = gitHubRepo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepoViewHolder {
        return GitHubRepoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_github_repo, parent, false)
        )
    }

    override fun getItemCount() = gitHubRepos.size

    override fun onBindViewHolder(holder: GitHubRepoViewHolder, position: Int) {
        holder.bind(gitHubRepos[position])
        holder.textRepoName.text = gitHubRepos[position].name
        holder.textRepoDescription.text = gitHubRepos[position].description
        holder.textLanguage.text = "Language: ${gitHubRepos[position].language}"
        holder.textStars.text = "Stars: ${gitHubRepos[position].stargazersCount}"
        Log.d("Adapter", gitHubRepos[position].toString())
    }

    fun setGitHubRepos(repos: List<GitHubRepo>?) {
        if (repos == null) {
            return
        }
        gitHubRepos.clear()
        gitHubRepos.addAll(repos)
        notifyDataSetChanged()
    }

    class GitHubRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var textRepoName: TextView
        lateinit var textRepoDescription: TextView
        lateinit var textLanguage: TextView
        lateinit var textStars: TextView
        fun bind(item: GitHubRepo) = with(itemView) {
            textRepoName = itemView.findViewById(R.id.text_repo_name)
            textRepoDescription = itemView.findViewById(R.id.text_repo_description)
            textLanguage = itemView.findViewById(R.id.text_language)
            textStars = itemView.findViewById(R.id.text_stars)

            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}