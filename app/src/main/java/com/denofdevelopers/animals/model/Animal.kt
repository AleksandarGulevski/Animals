package com.denofdevelopers.animals.model

import kotlinx.serialization.SerialName

data class Animal(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("species")
    val species: String,
    @SerialName("family")
    val family: String,
    @SerialName("habitat")
    val habitat: String,
    @SerialName("place_of_found")
    val placeWhereFound: String,
    @SerialName("diet")
    val diet: String,
    @SerialName("description")
    val description: String,
    @SerialName("weight_kg")
    val weightKg: Int,
    @SerialName("height_cm")
    val heightCm: Int,
    @SerialName("image")
    val image: String
)
