package expo.modules.miniapp.screens

import android.content.Context
import android.webkit.WebView
import android.widget.LinearLayout
import expo.modules.miniapp.common.uiHelper.dp
import expo.modules.miniapp.components.HeaderComponent

class MiniAppScreen(context: Context) : LinearLayout(context) {
    private val rootLayout = LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
    }

    internal val webView = WebView(context).apply {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            context.dp(700),
            1f   // chiếm phần còn lại như 1 screen
        )
    }

    private val headerView = HeaderComponent(context)
    // func action

    init {
        rootLayout.addView(headerView)
        rootLayout.addView(webView)
        addView(rootLayout)
    }
}