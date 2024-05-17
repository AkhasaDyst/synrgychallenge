package com.yudhi.moviedatabase.model.movie

import com.google.gson.annotations.SerializedName

data class RatingRequest(
    @SerializedName("value")
    val values12: Double
)

