package easy.com.br.easygithubapp.repository

import android.arch.lifecycle.LiveData
import easy.com.br.easygithubapp.domain.model.RepositoriesApiResult
import easy.com.br.easygithubapp.domain.model.Result

interface GitHubRepository {
    fun getRepositories(): LiveData<Result<RepositoriesApiResult, String>>
}
