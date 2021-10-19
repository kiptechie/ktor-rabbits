package com.kiptechie.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Rabbit(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String
)
