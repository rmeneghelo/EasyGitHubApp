package easy.com.br.easygithubapp.view.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.domain.model.UserRepository
import easy.com.br.easygithubapp.view.feed.holder.RepositoriesHolder
import kotlinx.android.synthetic.main.github_repository_row.view.*

class RepositoriesAdapter(items: List<UserRepository>, private val clickListener: (UserRepository) -> Unit)
    : RecyclerView.Adapter<RepositoriesHolder>() {

    private var repositoriesList: List<UserRepository> = items

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var githubRepositoryName: TextView = view.githubRepositoryName
        var description: TextView = view.description
        var authorName: TextView = view.authorName
        var authorPhoto: ImageView = view.authorPhoto
        var forksPhoto: ImageView = view.forksPhoto
        var starsNumber: TextView = view.starsNumber
        var forksNumber: TextView = view.forksNumber
        var starPhoto: ImageView = view.starPhoto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.github_repository_row, parent, false)

        return RepositoriesHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepositoriesHolder, position: Int) {
        val repository = repositoriesList[position]
        holder?.run { showRepositories(repository, clickListener) }
    }

    override fun getItemCount(): Int = repositoriesList.size
}