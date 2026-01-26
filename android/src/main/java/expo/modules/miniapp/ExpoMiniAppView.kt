package expo.modules.miniapp

import android.content.Context
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher
import expo.modules.kotlin.views.ExpoView
import expo.modules.miniapp.screens.MiniAppScreen

class ExpoMiniAppView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
  // Creates and initializes an event dispatcher for the `onLoad` event.
  // The name of the event is inferred from the value and needs to match the event name defined in the module.
  private val onLoad by EventDispatcher()

  private val miniAppScreen = MiniAppScreen(context)

  fun loadUrl(url: String) {
    miniAppScreen.webView.loadUrl(url)
  }

  init {
    addView(miniAppScreen)
  }
}
