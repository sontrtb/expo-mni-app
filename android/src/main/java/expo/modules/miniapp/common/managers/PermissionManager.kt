package expo.modules.miniapp.common.managers

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

/**
 * PermissionManager - Quản lý các quyền ứng dụng
 */
class PermissionManager(private val context: Context) {

  /**
   * Kiểm tra xem ứng dụng có quyền được chỉ định không
   */
  fun hasPermission(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
      context,
      permission
    ) == PackageManager.PERMISSION_GRANTED
  }

  /**
   * Kiểm tra nhiều quyền cùng lúc
   */
  fun hasPermissions(permissions: List<String>): Boolean {
    return permissions.all { hasPermission(it) }
  }

  companion object {
    // Các quyền thường dùng
    const val CAMERA = android.Manifest.permission.CAMERA
    const val CALL_PHONE = android.Manifest.permission.CALL_PHONE
    const val SEND_SMS = android.Manifest.permission.SEND_SMS
    const val READ_CONTACTS = android.Manifest.permission.READ_CONTACTS
    const val WRITE_CONTACTS = android.Manifest.permission.WRITE_CONTACTS
    const val ACCESS_FINE_LOCATION = android.Manifest.permission.ACCESS_FINE_LOCATION
  }
}
