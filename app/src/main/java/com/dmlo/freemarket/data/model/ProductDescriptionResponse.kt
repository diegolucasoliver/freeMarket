package com.dmlo.freemarket.data.model

import com.google.gson.annotations.SerializedName

class ProductDescriptionResponse(
    @SerializedName("text") val text: String,
    @SerializedName("plain_text") val plainText: String,
    @SerializedName("snapshot") val snapshot: SnapshotResponse
)

class SnapshotResponse(
    @SerializedName("url") val url: String,
)