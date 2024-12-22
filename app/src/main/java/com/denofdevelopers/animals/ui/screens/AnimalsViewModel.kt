package com.denofdevelopers.animals.ui.screens

import androidx.lifecycle.ViewModel

class AnimalsViewModel : ViewModel() {

    private val BASE_URL = "https://www.freetestapi.com/api/v1/"
    val path = "animals?limit=5"
}