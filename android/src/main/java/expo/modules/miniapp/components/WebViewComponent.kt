package expo.modules.miniapp.components

import android.content.Context
import android.webkit.WebView
import android.widget.LinearLayout
import expo.modules.miniapp.common.uiHelper.dp

class WebViewComponent(context: Context) : LinearLayout(context) {
  internal val webView = WebView(context).apply {
    layoutParams = LayoutParams(
      LayoutParams.MATCH_PARENT,
      context.dp(700),
      1f   // chiếm phần còn lại như 1 screen
    )
  }

  init {
    addView(webView)
  }
}