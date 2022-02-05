package com.example.assignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ratings(
    @SerializedName("Source") val source : String,
    @SerializedName("Value") val value : String
) : Parcelable
