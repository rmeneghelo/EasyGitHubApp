package easy.com.br.easygithubapp.domain.model

data class HeaderDto(var totalRepositories: Int,
                     var totalMoreThanHundredOpenIssues: Int) {
    constructor(): this(0,0)
}

