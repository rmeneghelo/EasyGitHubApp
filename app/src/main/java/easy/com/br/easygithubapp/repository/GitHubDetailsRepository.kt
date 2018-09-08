package easy.com.br.easygithubapp.repository

import easy.com.br.easygithubapp.domain.model.RepositoryDetail
import retrofit2.Callback

interface GitHubDetailsRepository {
    fun getRepositoryDetails(username: String,
                             repositoryName: String,
                             call: Callback<List<RepositoryDetail>>)
}