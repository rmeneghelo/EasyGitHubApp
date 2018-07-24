package easy.com.br.easygithubapp.adapters

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.domain.model.UserRepository
import kotlinx.android.synthetic.main.github_repository_row.view.*

class RepositoriesAdapter(items: List<UserRepository>, private val clickListener: (UserRepository) -> Unit)
    : RecyclerView.Adapter<RepositoriesAdapter.MyViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.github_repository_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val repository = repositoriesList[position]
        holder.githubRepositoryName.text = repository.githubRepositoryName
        holder.description.text = repository.description
        holder.authorName.text = repository.owner.authorName
        holder.starsNumber.text = repository.starsNumber.toString()
        holder.forksNumber.text = repository.forksNumber.toString()

        repository.owner.authorPhoto.let {
            if (it.isNotEmpty()){
                Picasso
                        .get()
                        .load(repository.owner.authorPhoto)
                        .into(holder.authorPhoto)
            }
        }

        Picasso
                .get()
                .load(R.drawable.repo_fork)
                .into(holder.forksPhoto)

        Picasso
                .get()
                .load(R.drawable.star_repository)
                .into(holder.starPhoto)

        repository.license.let {
            if(it.isApacheLicense){
                holder.itemView.setBackgroundColor(Color.LTGRAY)
            }
            else{
                holder.itemView.setBackgroundColor(Color.WHITE)
            }
        }

        holder.itemView.setOnClickListener {
            clickListener(repository)
        }
    }



    override fun getItemCount(): Int = repositoriesList.size
}