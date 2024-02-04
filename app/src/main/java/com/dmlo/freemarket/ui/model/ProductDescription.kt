package com.dmlo.freemarket.ui.model

import com.dmlo.freemarket.data.model.ProductDescriptionResponse
import com.dmlo.freemarket.data.model.SnapshotResponse

class ProductDescription(
    val text: String = "",
    val plainText: String = "",
    val lastUpdated: String = "",
    val dateCreated: String = "",
    val snapshot: Snapshot = Snapshot()
) {
    constructor(response: ProductDescriptionResponse) : this(
        text = response.text,
        plainText = response.plainText,
        lastUpdated = response.lastUpdated,
        dateCreated = response.dateCreated,
        snapshot = Snapshot(response.snapshot)
    )
}

class Snapshot(
    val url: String = "",
    val width: String = "",
    val height: String = "",
    val status: String = ""
) {
    constructor(response: SnapshotResponse) : this(
        url = response.url,
        width = response.width,
        height = response.height,
        status = response.status
    )
}