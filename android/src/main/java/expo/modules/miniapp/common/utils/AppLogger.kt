package expo.modules.miniapp.common.utils

import android.util.Log

/**
 * AppLogger - Tiện ích ghi log
 */
object AppLogger {
  private const val TAG = "ExpoMiniApp"

  fun debug(message: String) {
    Log.d(TAG, message)
  }

  fun info(message: String) {
    Log.i(TAG, message)
  }

  fun warning(message: String) {
    Log.w(TAG, message)
  }

  fun error(message: String, throwable: Throwable? = null) {
    Log.e(TAG, message, throwable)
  }
}
