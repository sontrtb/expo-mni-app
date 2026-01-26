package expo.modules.miniapp.screens

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
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

    private val headerView = HeaderComponent(context)

    private fun setupHeaderView() {
        headerView.setOnBackClickListener {
            goBack()
        }
    }

    internal val webView = WebView(context).apply {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            context.dp(700),
            1f // chiếm phần còn lại như 1 screen
        )
    }

    // Biến real-time để theo dõi khả năng back
    private var _canGoBack: Boolean = false
        set(value) {
            field = value
            // Update header khi giá trị thay đổi
            headerView.setBackButtonVisible(value)
        }

    // func action
    init {
        setupWebView()
        setupHeaderView()
        rootLayout.addView(headerView)
        rootLayout.addView(webView)
        addView(rootLayout)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                updateBackButtonState()
            }

            override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
                super.doUpdateVisitedHistory(view, url, isReload)
                updateBackButtonState()
            }
        }
    }


    private fun updateBackButtonState() {
        _canGoBack = webView.canGoBack()
    }

    // Function để thực hiện back trong WebView
    fun goBack() {
        if (webView.canGoBack()) {
            webView.goBack()
        }
    }
}