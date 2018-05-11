package easy.com.br.easygithubapp.Domain.Model

data class RepositoryDto(
        var githubRepositoryName: String,
        var description: String,
        var owner: Owner,
        var license: License,
        var starsNumber: Int,
        var forksNumber: Int)

data class Owner(
        var authorName: String,
        var authorPhoto: String
)

data class License(
        var isApacheLicense: Boolean
)