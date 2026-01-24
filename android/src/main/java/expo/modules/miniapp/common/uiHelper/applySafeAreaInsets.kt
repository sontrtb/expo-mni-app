import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun View.applySafeAreaInsets(
    applyTop: Boolean = true,
    applyBottom: Boolean = true
) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

        view.setPadding(
            paddingLeft,
            if (applyTop) systemBars.top else paddingTop,
            paddingRight,
            if (applyBottom) systemBars.bottom else paddingBottom
        )
        insets
    }
}
