package expo.modules.miniapp.components

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import expo.modules.miniapp.common.uiHelper.dp

class HeaderComponent(context: Context) : LinearLayout(context) {
  var statusBarHeight = resources.getDimensionPixelSize(
    resources.getIdentifier("status_bar_height", "dimen", "android")
  )

  private val backButton = ImageView(context).apply {
    setImageResource(android.R.drawable.ic_menu_revert)
//    setColorFilter(Color.WHITE)
    layoutParams = LayoutParams(context.dp(48), context.dp(48)).apply {
      gravity = Gravity.CENTER_VERTICAL
    }
    scaleType = ImageView.ScaleType.CENTER
    setPadding(context.dp(12), context.dp(12), context.dp(12), context.dp(12))
  }

  private val titleView = TextView(context).apply {
    text = "Mini App"
//    setTextColor(Color.WHITE)
    textSize = 18f
    layoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f).apply {
      gravity = Gravity.CENTER_VERTICAL
    }
    gravity = Gravity.CENTER
  }

  private val closeButton = ImageView(context).apply {
    setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
//    setColorFilter(Color.WHITE)
    layoutParams = LayoutParams(context.dp(48), context.dp(48)).apply {
      gravity = Gravity.CENTER_VERTICAL
    }
    scaleType = ImageView.ScaleType.CENTER
    setPadding(context.dp(12), context.dp(12), context.dp(12), context.dp(12))
  }

  init {
    layoutParams = LayoutParams(
      LayoutParams.MATCH_PARENT,
      statusBarHeight + context.dp(56)
    )
//    setBackgroundColor(Color.BLACK)
    orientation = HORIZONTAL
    gravity = Gravity.CENTER_VERTICAL
    setPadding(0, statusBarHeight, 0, 0)

    addView(backButton)
    addView(titleView)
    addView(closeButton)
  }

  fun setTitle(title: String) {
    titleView.text = title
  }

  fun setOnBackClickListener(listener: OnClickListener) {
    backButton.setOnClickListener(listener)
  }

  fun setOnCloseClickListener(listener: OnClickListener) {
    closeButton.setOnClickListener(listener)
  }
}