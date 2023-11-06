package com.example.eldenringworld.model

import android.os.Parcel
import android.os.Parcelable

data class locationData(
    val description: String,
    val id: String,
    val image: String,
    val name: String,
    val region: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeString(id)
        parcel.writeString(image)
        parcel.writeString(name)
        parcel.writeString(region)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<locationData> {
        override fun createFromParcel(parcel: Parcel): locationData {
            return locationData(parcel)
        }

        override fun newArray(size: Int): Array<locationData?> {
            return arrayOfNulls(size)
        }
    }
}