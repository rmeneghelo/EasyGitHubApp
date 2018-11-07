package easy.com.br.easygithubapp.view.feed.holder

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.github_repository_detail_row.view.*

class RepositoryDetailsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun showRepositoryDetails(repositoryDetail: RepositoryDetail): Unit = with(itemView) {
        tvPullRequestTitle.text = repositoryDetail.pullRequestTitle
        tvPullRequestCreationDate.text = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(repositoryDetail.pullRequestCreationDate)
        tvPullRequestBody.text = repositoryDetail.pullRequestBody
        tvUsername.text = repositoryDetail.user.username

        repositoryDetail.user.userPhoto.let {
            if (it.isNotEmpty()) {
                Picasso
                        .get()
                        .load(repositoryDetail.user.userPhoto)
                        .into(userPhoto)
            }
        }
    }
}