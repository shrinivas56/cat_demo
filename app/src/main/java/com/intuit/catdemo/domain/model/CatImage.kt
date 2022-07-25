package com.intuit.catdemo.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CatImage(
    @Json(name = "id")
    val id: String?,
    @Json(name = "width")
    val width: Int?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "url")
    val url: String?
): Parcelable