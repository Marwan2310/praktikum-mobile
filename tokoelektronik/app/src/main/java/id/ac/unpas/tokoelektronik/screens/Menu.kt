package id.ac.unpas.tokoelektronik.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import id.ac.unpas.tokoelektronik.R

enum class Menu (
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    HOME(R.string.home, Icons.Default.Home, "home"),
    KOMPUTER(R.string.komputer,
        Icons.Default.List, "komputer"),
    PERIFERAL(R.string.periferal,
        Icons.Default.List, "periferal"),
    SETTING(R.string.setting, Icons.Default.Settings,
        "setting");
    companion object {
        fun getTabFromResource(@StringRes resource: Int) : Menu
        {
            return when (resource) {
                R.string.home -> HOME
                R.string.komputer ->
                    KOMPUTER
                R.string.periferal ->
                    PERIFERAL
                else -> SETTING
            }
        }
    }
}