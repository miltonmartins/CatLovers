package com.martins.milton.catlovers.data.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("data") var cats: List<Cat>
)