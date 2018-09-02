package easy.com.br.easygithubapp.view.feed.holder

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import easy.com.br.easygithubapp.R
import easy.com.br.easygithubapp.domain.model.UserRepository
import kotlinx.android.synthetic.main.github_repository_row.view.*

class RepositoriesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun showRepositories(userRepository: UserRepository, clickListener: (UserRepository) -> Unit): Unit = with(itemView) {
        githubRepositoryName.text = userRepository.githubRepositoryName
        description.text = userRepository.description
        authorName.text = userRepository.owner.authorName
        starsNumber.text = userRepository.starsNumber.toString()
        forksNumber.text = userRepository.forksNumber.toString()

        userRepository.owner.authorPhoto.let {
            if (it.isNotEmpty()) {
                Picasso
                        .get()
                        .load(userRepository.owner.authorPhoto)
                        .into(authorPhoto)
            }
        }

        Picasso
                .get()
                .load(R.drawable.repo_fork)
                .into(forksPhoto)

        Picasso
                .get()
                .load(R.drawable.star_repository)
                .into(starPhoto)

        userRepository.license.let {
            if (it.isApacheLicense) {
                itemView.setBackgroundColor(Color.LTGRAY)
            } else {
                itemView.setBackgroundColor(Color.WHITE)
            }
        }

        itemView.setOnClickListener {
            clickListener(userRepository)
        }
    }
}