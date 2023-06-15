package id.ac.unpas.tokoelektronik.screens

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import id.ac.unpas.tokoelektronik.R

enum class Menu (
    @StringRes val title: Int,
    val icon: Int,
    val route: String
) {
    KOMPUTER(R.string.komputer, R.drawable.baseline_computer_24, "komputer"),
    PERIFERAL(R.string.periferal, R.drawable.baseline_keyboard_24, "periferal"),
    SMARTPHONE(R.string.smartphone, R.drawable.baseline_smartphone_24, "smartphone"),
    ABOUTTEAM(R.string.aboutteam, R.drawable.baseline_people_alt_24, "aboutteam");
    companion object {
        fun getTabFromResource(@StringRes resource: Int) : Menu
        {
            return when (resource) {
                R.string.komputer ->
                    KOMPUTER
                R.string.periferal ->
                    PERIFERAL
                R.string.smartphone ->
                    SMARTPHONE
                R.string.aboutteam ->
                    ABOUTTEAM
                else -> ABOUTTEAM
            }
        }
    }
}