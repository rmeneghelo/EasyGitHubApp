package easy.com.br.easygithubapp.Model

import com.google.gson.annotations.SerializedName

data class RepositoriesResult(var items: List<Repository>)

data class Repository(
        @SerializedName("full_name")
        var githubRepositoryName: String,
        var description: String,
        var owner: Owner,
        @SerializedName("stargazers_count")
        var starsNumber: Int,
        @SerializedName("forks_count")
        var forksNumber: Int)

data class Owner(
        @SerializedName("login")
        var authorName: String,
        @SerializedName("avatar_url")
        var authorPhoto: String
)