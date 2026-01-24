package expo.modules.miniapp.common.uiHelper

import android.content.Context
import android.util.TypedValue

fun Context.dp(dp: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        resources.displayMetrics
    ).toInt()
}
