package expo.modules.miniapp.components

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class HeaderView(context: Context) : LinearLayout(context) {
  private val titleView = TextView(context).apply {
    text = "Mini App"
    setTextColor(Color.WHITE)
    textSize = 18f
    setPadding(16, 0, 0, 0)
  }

  init {
    layoutParams = LayoutParams(
      LayoutParams.MATCH_PARENT,
      56
    )
    setBackgroundColor(Color.BLACK)
    gravity = Gravity.CENTER_VERTICAL
    addView(titleView)
  }

  fun setTitle(title: String) {
    titleView.text = title
  }
}