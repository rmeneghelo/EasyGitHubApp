package easy.com.br.easygithubapp.repository

import androidx.lifecycle.LiveData
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.domain.model.UserRepositoryDetail

interface GitHubDetailsRepository {
    fun getRepositoryDetails(userRepositoryDetail: UserRepositoryDetail): LiveData<MutableList<RepositoryDetail>>
}