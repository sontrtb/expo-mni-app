package expo.modules.miniapp.common.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * SharedPrefUtils - Tiện ích để làm việc với SharedPreferences
 */
class SharedPrefUtils(context: Context) {
  private val sharedPreferences: SharedPreferences =
    context.getSharedPreferences("expo_mini_app_prefs", Context.MODE_PRIVATE)

  fun putString(key: String, value: String) {
    sharedPreferences.edit().putString(key, value).apply()
  }

  fun getString(key: String, defaultValue: String = ""): String {
    return sharedPreferences.getString(key, defaultValue) ?: defaultValue
  }

  fun putInt(key: String, value: Int) {
    sharedPreferences.edit().putInt(key, value).apply()
  }

  fun getInt(key: String, defaultValue: Int = 0): Int {
    return sharedPreferences.getInt(key, defaultValue)
  }

  fun putBoolean(key: String, value: Boolean) {
    sharedPreferences.edit().putBoolean(key, value).apply()
  }

  fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
    return sharedPreferences.getBoolean(key, defaultValue)
  }

  fun remove(key: String) {
    sharedPreferences.edit().remove(key).apply()
  }

  fun clear() {
    sharedPreferences.edit().clear().apply()
  }
}
