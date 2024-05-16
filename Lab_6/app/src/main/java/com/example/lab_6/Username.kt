package com.example.lab_6

import android.os.Parcel
import android.os.Parcelable

data class Username (
    val firstName:String,
    val lastName:String,
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Username> {
        override fun createFromParcel(parcel: Parcel): Username {
            return Username(parcel)
        }

        override fun newArray(size: Int): Array<Username?> {
            return arrayOfNulls(size)
        }
    }

}