package expo.modules.miniapp.common.managers

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.SmsManager

/**
 * PhoneManager - Quản lý các chức năng liên quan đến điện thoại
 */
class PhoneManager(private val context: Context) {

  /**
   * Gọi điện đến số điện thoại được chỉ định
   * @param phoneNumber Số điện thoại cần gọi
   */
  fun makeCall(phoneNumber: String, onResult: (Boolean) -> Unit) {
    try {
      val intent = Intent(Intent.ACTION_CALL).apply {
        data = Uri.parse("tel:$phoneNumber")
      }
      context.startActivity(intent)
      onResult(true)
    } catch (e: Exception) {
      onResult(false)
    }
  }

  /**
   * Gửi tin nhắn SMS
   * @param phoneNumber Số điện thoại người nhận
   * @param message Nội dung tin nhắn
   */
  fun sendSMS(phoneNumber: String, message: String, onResult: (Boolean) -> Unit) {
    try {
      val smsManager = SmsManager.getDefault()
      smsManager.sendTextMessage(phoneNumber, null, message, null, null)
      onResult(true)
    } catch (e: Exception) {
      onResult(false)
    }
  }

  /**
   * Kiểm tra xem điều kiện điện thoại có đủ không
   */
  fun hasPhonePermission(): Boolean {
    // TODO: Kiểm tra quyền gọi điện và gửi SMS
    return true
  }
}
