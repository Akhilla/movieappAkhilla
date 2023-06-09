package com.example.movieapp_akhilla.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Movie (

    @SerializedName("id")
    val id :String?,

    @SerializedName("title")
    val title :String?,

    @SerializedName("poster_path")
    val poster_path :String?,

    @SerializedName("release_date")
    val release_date :String?,

    ) :Parcelable{
        constructor() : this("", "", "", "")
    }

