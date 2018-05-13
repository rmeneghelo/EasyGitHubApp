package easy.com.br.easygithubapp.Domain.Model

data class RepositoryDto(
        var totalCount: Int,
        var openIssuesMoreThanHundred: Int,
        var listRepositories: List<Repository>
        )

data class Repository(var githubRepositoryName: String,
                      var description: String,
                      var owner: Owner,
                      var license: License,
                      var starsNumber: Int,
                      var forksNumber: Int,
                      var openIssuesNumber: Int)

data class Owner(
        var authorName: String,
        var authorPhoto: String
)

data class License(
        var isApacheLicense: Boolean
)