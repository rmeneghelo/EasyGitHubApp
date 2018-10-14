package easy.com.br.easygithubapp.repository

import android.arch.lifecycle.LiveData
import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import easy.com.br.easygithubapp.domain.model.UserRepositoryDetail

interface GitHubDetailsRepository {
    fun getRepositoryDetails(userRepositoryDetail: UserRepositoryDetail): LiveData<List<RepositoryDetail>>
}