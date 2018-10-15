package easy.com.br.easygithubapp.domain.model

sealed class Result<out V, out E>

data class ValueResult<out V>(val value: V) : Result<V, Nothing>()

data class ErrorResult<out E>(val error: E) : Result<Nothing, E>()