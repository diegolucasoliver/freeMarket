package com.dmlo.freemarket.data.model

import com.google.gson.annotations.SerializedName

class ProductDescriptionResponse(
    @SerializedName("text") val text: String,
    @SerializedName("plain_text") val plainText: String,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("date_created") val dateCreated: String,
    @SerializedName("snapshot") val snapshot: SnapshotResponse
)

class SnapshotResponse(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: String,
    @SerializedName("height") val height: String,
    @SerializedName("status") val status: String
)