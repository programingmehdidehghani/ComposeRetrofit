package com.example.composeretrofit.data.remote.response

data class PokemoneList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)