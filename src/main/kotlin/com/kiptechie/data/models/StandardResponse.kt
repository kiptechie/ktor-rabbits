package com.kiptechie.data.models

import kotlinx.serialization.Serializable

@Serializable
data class StandardResponse @JvmOverloads constructor(
    val success: Boolean,
    val message: String,
    val rabbits: List<Rabbit>? = null,
    val rabbit: Rabbit? = null,
    val count: Int? = null,
)
