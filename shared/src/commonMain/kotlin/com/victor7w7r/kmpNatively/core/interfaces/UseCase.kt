package com.victor7w7r.kmpNatively.core.interfaces

import arrow.core.Either
import arrow.core.Option
import kotlinx.coroutines.flow.Flow

fun interface UseCase<T, U> {
  operator fun invoke(): Flow<Option<Either<T, U>>>
}
