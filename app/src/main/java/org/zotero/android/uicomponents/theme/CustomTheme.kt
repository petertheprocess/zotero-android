package org.zotero.android.uicomponents.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import org.zotero.android.uicomponents.CustomUriHandler

/**
 * CompositionLocal to provide E-ink mode state throughout the app.
 * When true, animations should be disabled and high-contrast colors used.
 */
val LocalEInkMode = staticCompositionLocalOf { false }

object CustomTheme {
    val colors
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColors.current

    val typography
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomTypography.current

    val shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomShapes.current

    val isEInkMode
        @Composable
        @ReadOnlyComposable
        get() = LocalEInkMode.current
}

@Composable
fun CustomTheme(
    dynamicThemeColors: DynamicThemeColors = DynamicThemeColors(),
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isEInkMode: Boolean = false,
    content: @Composable () -> Unit
) {
    val customTypography = CustomTypography()
    val customColors = createSemanticColors(
        dynamicThemeColors = dynamicThemeColors,
        isDarkTheme = isDarkTheme,
        isEInkMode = isEInkMode
    )

    CompositionLocalProvider(
        LocalCustomTypography provides customTypography,
        LocalTextStyle provides customTypography.default,
        LocalCustomColors provides customColors,
        LocalContentColor provides customColors.primaryContent,
        LocalRippleConfiguration provides CustomRippleTheme.createCustomRippleTheme(),
        LocalCustomShapes provides CustomShapes(),
        LocalUriHandler provides CustomUriHandler(LocalContext.current),
        LocalEInkMode provides isEInkMode,
    ) {
        content()
    }
}

@Composable
fun CustomThemeWithStatusAndNavBars(
    dynamicThemeColors: DynamicThemeColors = DynamicThemeColors(),
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isEInkMode: Boolean = false,
    content: @Composable () -> Unit
) {
    val customTypography = CustomTypography()
    val customColors = createSemanticColors(
        dynamicThemeColors = dynamicThemeColors,
        isDarkTheme = isDarkTheme,
        isEInkMode = isEInkMode
    )

    CompositionLocalProvider(
        LocalCustomTypography provides customTypography,
        LocalTextStyle provides customTypography.default,
        LocalCustomColors provides customColors,
        LocalContentColor provides customColors.primaryContent,
        LocalRippleConfiguration provides CustomRippleTheme.createCustomRippleTheme(),
        LocalCustomShapes provides CustomShapes(),
        LocalUriHandler provides CustomUriHandler(LocalContext.current),
        LocalEInkMode provides isEInkMode,
    ) {
        content()
    }

}
