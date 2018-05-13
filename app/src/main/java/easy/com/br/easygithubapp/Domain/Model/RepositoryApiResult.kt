package easy.com.br.easygithubapp.Model

import com.google.gson.annotations.SerializedName

data class RepositoryApiResult(var total_count: Int, var items: List<Repository>)

data class Repository(
        @SerializedName("name")
        var githubRepositoryName: String,
        var description: String,
        var owner: Owner,
        var license: License,
        @SerializedName("stargazers_count")
        var starsNumber: Int,
        @SerializedName("forks_count")
        var forksNumber: Int,
        @SerializedName("open_issues")
        var openIssuesNumber: Int)

data class Owner(
        @SerializedName("login")
        var authorName: String,
        @SerializedName("avatar_url")
        var authorPhoto: String
)

data class License(
        @SerializedName("key")
        var licenseKey: String
)