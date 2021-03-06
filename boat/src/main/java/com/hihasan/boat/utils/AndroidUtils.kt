package com.hihasan.boat.utils

import android.os.Build
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup

typealias Scope = () -> Unit

internal inline fun applyForApiLAndHigher(scope: Scope) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        scope()
    }
}

internal fun ViewGroup.delayTransition(duration: Long = -1L) {
    val autoTransition = AutoTransition()
    autoTransition.duration = duration
    TransitionManager.beginDelayedTransition(this, autoTransition)
}

internal fun View.show(isShown: Boolean = false) {
    this.visibility = if (isShown)  View.VISIBLE else View.GONE
}

