package com.victor7w7r.kmpNatively.core.interfaces

import arrow.core.Either
import arrow.core.Option
import kotlinx.coroutines.flow.Flow

fun interface SingleUseCase<T> {
  operator fun invoke(): T
}

fun interface FlowEitherUseCase<T, U> {
  operator fun invoke(): Flow<Option<Either<T, U>>>
}
