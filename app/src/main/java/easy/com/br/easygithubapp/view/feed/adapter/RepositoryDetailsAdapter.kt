package easy.com.br.easygithubapp.view.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.view.feed.holder.RepositoryDetailsHolder

class RepositoryDetailsAdapter : RecyclerView.Adapter<RepositoryDetailsHolder>() {
    private val repositoryDetailsList = mutableListOf<RepositoryDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryDetailsHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.github_repository_detail_row, parent, false)

        return RepositoryDetailsHolder(itemView)
    }

    override fun getItemCount(): Int = repositoryDetailsList.size

    override fun onBindViewHolder(holder: RepositoryDetailsHolder, position: Int) {
        val repositoryDetail = repositoryDetailsList[position]
        holder.run { showRepositoryDetails(repositoryDetail) }
    }

    fun addItems(newRepositories: List<RepositoryDetail>) {
        repositoryDetailsList.addAll(newRepositories)
        notifyDataSetChanged()
    }
}