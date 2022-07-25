package com.intuit.catdemo.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CatWeight(
    @Json(name = "imperial")
    val imperial: String?,
    @Json(name = "metric")
    val metric: String?
): Parcelable