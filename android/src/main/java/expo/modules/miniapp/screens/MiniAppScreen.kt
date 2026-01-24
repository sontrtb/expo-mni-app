package expo.modules.miniapp.screens

import android.content.Context
import android.widget.LinearLayout
import expo.modules.miniapp.components.HeaderComponent
import expo.modules.miniapp.components.WebViewComponent

class MiniAppScreen(context: Context) : LinearLayout(context) {
    private val rootLayout = LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
    }

    private val headerView = HeaderComponent(context)
    // func action
    internal val webView = WebViewComponent(context)

    init {
        rootLayout.addView(headerView)
        rootLayout.addView(webView)
        addView(rootLayout)
    }
}