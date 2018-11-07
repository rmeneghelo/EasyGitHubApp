package easy.com.br.easygithubapp.view.feed.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.domain.model.UserRepository
import easy.com.br.easygithubapp.view.feed.holder.RepositoriesHolder

class RepositoriesAdapter(private val clickListener: (UserRepository) -> Unit)
    : RecyclerView.Adapter<RepositoriesHolder>() {

    private val repositoriesList = mutableListOf<UserRepository>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.github_repository_row, parent, false)

        return RepositoriesHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepositoriesHolder, position: Int) {
        val repository = repositoriesList[position]
        holder.run { showRepositories(repository, clickListener) }
    }

    override fun getItemCount(): Int = repositoriesList.size

    fun addItems(newRepositories: List<UserRepository>) {
        repositoriesList.addAll(newRepositories)
        notifyDataSetChanged()
    }
}