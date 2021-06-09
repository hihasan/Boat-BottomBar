package com.hihasan.boat.state

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class NotificationBadgeSavedState(
    val badgeColor: Int,
    val badgeTextColor: Int,
    val badgeText: String?,
    val shouldShowBadge: Boolean,
    val superState: Parcelable?
): Parcelable
