package com.example.movieapp_akhilla.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse (
    @SerializedName("results")
    val movie: List<Movie>
)
    : Parcelable {
    constructor():this(mutableListOf())
}