package easy.com.br.easygithubapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.R
import kotlinx.android.synthetic.main.github_repository_detail_row.view.*
import java.text.SimpleDateFormat
import java.util.*

class RepositoryDetailsAdapter (items: List<RepositoryDetail>?)
    : RecyclerView.Adapter<RepositoryDetailsAdapter.MyViewHolder>() {

    var repositoryDetailsList: List<RepositoryDetail>? = items

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var pullRequestTitle: TextView = view.tvPullRequestTitle
        var pullRequestCreationDate: TextView = view.tvPullRequestCreationDate
        var pullRequestBody: TextView = view.tvPullRequestBody
        var username: TextView = view.tvUsername
        var userPhoto: ImageView = view.userPhoto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.github_repository_detail_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
        val repositoryDetail = repositoryDetailsList?.get(position)

        holder.pullRequestTitle.text = repositoryDetail?.pullRequestTitle
        holder.pullRequestCreationDate.text =  SimpleDateFormat("yyyy-MM-dd", Locale.US).format(repositoryDetail?.pullRequestCreationDate)
        holder.pullRequestBody.text = repositoryDetail?.pullRequestBody
        holder.username.text = repositoryDetail?.user?.username

        if(repositoryDetail?.user?.userPhoto!!.isNotEmpty())
        {
            Picasso
                    .get()
                    .load(repositoryDetail.user.userPhoto)
                    .into(holder.userPhoto)
        }

    }

    override fun getItemCount(): Int = repositoryDetailsList!!.size
}