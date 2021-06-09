package com.hihasan.boat

import androidx.annotation.ColorInt

internal interface NotificationBadge {

    @get:ColorInt
    var notificationBadgeBackgroundColor: Int

    @get:ColorInt
    var notificationBadgeTextColor: Int

    fun showNotification()

    @Throws(IllegalArgumentException::class)
    fun showNotification(text: String)

    fun clearNotification()

}
