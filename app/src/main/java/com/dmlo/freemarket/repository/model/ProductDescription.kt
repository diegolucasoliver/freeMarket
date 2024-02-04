package com.dmlo.freemarket.repository.model

import com.dmlo.freemarket.data.model.ProductDescriptionResponse
import com.dmlo.freemarket.data.model.SnapshotResponse

class ProductDescription(
    val text: String = "",
    val plainText: String = "",
    val snapshot: Snapshot = Snapshot()
) {
    constructor(response: ProductDescriptionResponse) : this(
        text = response.text,
        plainText = response.plainText,
        snapshot = Snapshot(response.snapshot)
    )
}

class Snapshot(
    val url: String = ""
) {
    constructor(response: SnapshotResponse) : this(
        url = response.url
    )
}