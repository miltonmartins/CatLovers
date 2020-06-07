package com.martins.milton.catlovers.data.models

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("title") var description: String,
    @SerializedName("images") var images: List<Image>
)