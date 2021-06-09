package com.hihasan.boat.state

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class BottomBarSavedState(
    val selectedItem: Int?,
    val superState: Parcelable?
): Parcelable
