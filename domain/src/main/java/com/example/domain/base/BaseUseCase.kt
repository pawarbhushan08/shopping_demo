package com.example.domain.base

import com.example.domain.model.Result

interface BaseUseCase<T : Any, R: Any> {
    suspend operator fun invoke(): Result<R>
}

interface BaseParameterUseCase<T : Any, R: Any> {
    suspend operator fun invoke(param: T): Result<R>
}