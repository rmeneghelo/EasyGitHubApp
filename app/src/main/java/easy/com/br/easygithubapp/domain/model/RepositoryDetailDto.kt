package easy.com.br.easygithubapp.domain.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class RepositoryDetail(
        @SerializedName("title")
        var pullRequestTitle: String,
        @SerializedName("created_at")
        var pullRequestCreationDate: Date,
        @SerializedName("body")
        var pullRequestBody: String,
        var user: User
)

data class User(
        @SerializedName("login")
        var username: String,
        @SerializedName("avatar_url")
        var userPhoto: String
)