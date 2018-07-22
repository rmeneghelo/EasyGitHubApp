package easy.com.br.easygithubapp.domain.model

data class RepositoryDto(
        var totalCount: Int,
        var openIssuesMoreThanHundred: Int,
        var listRepositories: List<UserRepository>
        )

data class UserRepository(var githubRepositoryName: String,
                      var description: String,
                      var owner: RepositoryOwner,
                      var license: RepositoryLicense,
                      var starsNumber: Int,
                      var forksNumber: Int,
                      var openIssuesNumber: Int)

data class RepositoryOwner(
        var authorName: String,
        var authorPhoto: String
)

data class RepositoryLicense(
        var isApacheLicense: Boolean
)