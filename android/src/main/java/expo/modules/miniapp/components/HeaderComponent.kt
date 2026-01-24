package expo.modules.miniapp.components

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import expo.modules.miniapp.common.uiHelper.dp

class HeaderComponent(context: Context) : LinearLayout(context) {
  var statusBarHeight = getResources().getDimensionPixelSize(
    getResources().getIdentifier("status_bar_height", "dimen", "android")
  )
  private val titleView = TextView(context).apply {
    text = "Mini App"
    setTextColor(Color.WHITE)
    textSize = 18f

  }

  init {
    layoutParams = LayoutParams(
      LayoutParams.MATCH_PARENT,
      context.dp(statusBarHeight) + context.dp(56)
    )

    setBackgroundColor(Color.BLACK)
    gravity = Gravity.CENTER_VERTICAL
    addView(titleView)
  }

  fun setTitle(title: String) {
    titleView.text = title
  }
}