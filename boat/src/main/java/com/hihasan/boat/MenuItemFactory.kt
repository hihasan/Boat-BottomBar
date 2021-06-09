package com.hihasan.boat

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.annotation.Px
import com.hihasan.boat.components.MenuItemView
import com.hihasan.boat.utils.DrawableHelper
import com.hihasan.boat.utils.StyleController

internal class MenuItemFactory(
    private val rootView: ExpandableBottomBar,
    private val styleController: StyleController,
    @Px private val itemVerticalPadding: Int,
    @Px private var itemHorizontalPadding: Int,
    @Px private var backgroundCornerRadius: Float,
    @FloatRange(from = 0.0, to = 1.0) private var backgroundOpacity: Float,
    @ColorInt private var itemInactiveColor: Int,
    @ColorInt private var globalNotificationBadgeColor: Int,
    @ColorInt private var globalNotificationBadgeTextColor: Int
) {

    fun build(
        menuItemDescriptor: MenuItemDescriptor,
        onItemClickListener: (MenuItem, View) -> Unit
    ): MenuItemImpl {
        val context: Context = rootView.context

        val itemView = MenuItemView(context = context)
        val menuItem = MenuItemImpl(
            menuItemDescriptor,
            rootView,
            itemView
        )

        val backgroundColorStateList = DrawableHelper.createSelectedUnselectedStateList(
            menuItemDescriptor.activeColor,
            itemInactiveColor
        )

        with(itemView) {
            id = menuItemDescriptor.itemId
            contentDescription = context.resources.getString(R.string.accessibility_item_description, menuItemDescriptor.text)
            setPadding(itemHorizontalPadding, itemVerticalPadding, itemHorizontalPadding, itemVerticalPadding)

            setIcon(menuItemDescriptor.iconId, backgroundColorStateList)
            setText(menuItemDescriptor.text, backgroundColorStateList)
            notificationBadgeBackgroundColor = menuItemDescriptor.badgeBackgroundColor ?: globalNotificationBadgeColor
            notificationBadgeTextColor = menuItemDescriptor.badgeTextColor ?: globalNotificationBadgeTextColor

            background = createHighlightedMenuShape(menuItemDescriptor)
            setOnClickListener {
                onItemClickListener(menuItem, it)
            }
        }

        return menuItem
    }

    private fun createHighlightedMenuShape(menuItemDescriptor: MenuItemDescriptor): Drawable {
        return styleController.createStateBackground(
            menuItemDescriptor.activeColor,
            backgroundCornerRadius,
            backgroundOpacity
        )
    }

}