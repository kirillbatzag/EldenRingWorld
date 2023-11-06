package com.example.eldenringworld.model


import android.os.Parcel
import android.os.Parcelable

data class bossData(
    val description: String,
    val drops: List<String>,
    val healthPoints: String,
    val id: String,
    val image: String,
    val location: String,
    val name: String,
    val region: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: emptyList(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeStringList(drops)
        parcel.writeString(healthPoints)
        parcel.writeString(id)
        parcel.writeString(image)
        parcel.writeString(location)
        parcel.writeString(name)
        parcel.writeString(region)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<bossData> {
        override fun createFromParcel(parcel: Parcel): bossData {
            return bossData(parcel)
        }

        override fun newArray(size: Int): Array<bossData?> {
            return arrayOfNulls(size)
        }
    }
}