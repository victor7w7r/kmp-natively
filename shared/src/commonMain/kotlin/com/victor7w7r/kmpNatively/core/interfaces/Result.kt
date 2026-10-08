package com.victor7w7r.kmpNatively.core.interfaces

sealed interface ResponseState<out T>

sealed interface Result<out T> : ResponseState<T> {
  data class Success<T>(
    val data: T,
  ) : ResponseState<T>

  data class Error(
    val message: String,
  ) : ResponseState<Nothing>

  data object Loading : ResponseState<Nothing>
}
