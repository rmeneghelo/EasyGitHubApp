package easy.com.br.easygithubapp.Model

data class Repository(var githubRepositoryName: String,
                  var description: String,
                  var authorName: String,
                  var authorPhoto: String,
                  var starsNumber: Int,
                  var forksNumber: Int)