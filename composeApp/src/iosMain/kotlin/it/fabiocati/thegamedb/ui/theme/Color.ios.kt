package it.fabiocati.thegamedb.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val primaryLight = Color(0xFF006A64)
private val onPrimaryLight = Color(0xFFFFFFFF)
private val primaryContainerLight = Color(0xFF9DF2E9)
private val onPrimaryContainerLight = Color(0xFF00504B)
private val secondaryLight = Color(0xFF4A6360)
private val onSecondaryLight = Color(0xFFFFFFFF)
private val secondaryContainerLight = Color(0xFFCCE8E4)
private val onSecondaryContainerLight = Color(0xFF324B49)
private val tertiaryLight = Color(0xFF47617A)
private val onTertiaryLight = Color(0xFFFFFFFF)
private val tertiaryContainerLight = Color(0xFFCFE5FF)
private val onTertiaryContainerLight = Color(0xFF2F4962)
private val errorLight = Color(0xFFBA1A1A)
private val onErrorLight = Color(0xFFFFFFFF)
private val errorContainerLight = Color(0xFFFFDAD6)
private val onErrorContainerLight = Color(0xFF93000A)
private val backgroundLight = Color(0xFFF4FBF9)
private val onBackgroundLight = Color(0xFF161D1C)
private val surfaceLight = Color(0xFFF4FBF9)
private val onSurfaceLight = Color(0xFF161D1C)
private val surfaceVariantLight = Color(0xFFDAE5E2)
private val onSurfaceVariantLight = Color(0xFF3F4947)
private val outlineLight = Color(0xFF6F7977)
private val outlineVariantLight = Color(0xFFBEC9C6)
private val scrimLight = Color(0xFF000000)
private val inverseSurfaceLight = Color(0xFF2B3231)
private val inverseOnSurfaceLight = Color(0xFFECF2F0)
private val inversePrimaryLight = Color(0xFF81D5CD)
private val surfaceDimLight = Color(0xFFD5DBD9)
private val surfaceBrightLight = Color(0xFFF4FBF9)
private val surfaceContainerLowestLight = Color(0xFFFFFFFF)
private val surfaceContainerLowLight = Color(0xFFEFF5F3)
private val surfaceContainerLight = Color(0xFFE9EFED)
private val surfaceContainerHighLight = Color(0xFFE3E9E8)
private val surfaceContainerHighestLight = Color(0xFFDDE4E2)

private val primaryDark = Color(0xFF81D5CD)
private val onPrimaryDark = Color(0xFF003733)
private val primaryContainerDark = Color(0xFF00504B)
private val onPrimaryContainerDark = Color(0xFF9DF2E9)
private val secondaryDark = Color(0xFFB0CCC8)
private val onSecondaryDark = Color(0xFF1C3532)
private val secondaryContainerDark = Color(0xFF324B49)
private val onSecondaryContainerDark = Color(0xFFCCE8E4)
private val tertiaryDark = Color(0xFFAFC9E7)
private val onTertiaryDark = Color(0xFF18324A)
private val tertiaryContainerDark = Color(0xFF2F4962)
private val onTertiaryContainerDark = Color(0xFFCFE5FF)
private val errorDark = Color(0xFFFFB4AB)
private val onErrorDark = Color(0xFF690005)
private val errorContainerDark = Color(0xFF93000A)
private val onErrorContainerDark = Color(0xFFFFDAD6)
private val backgroundDark = Color(0xFF0E1514)
private val onBackgroundDark = Color(0xFFDDE4E2)
private val surfaceDark = Color(0xFF0E1514)
private val onSurfaceDark = Color(0xFFDDE4E2)
private val surfaceVariantDark = Color(0xFF3F4947)
private val onSurfaceVariantDark = Color(0xFFBEC9C6)
private val outlineDark = Color(0xFF899391)
private val outlineVariantDark = Color(0xFF3F4947)
private val scrimDark = Color(0xFF000000)
private val inverseSurfaceDark = Color(0xFFDDE4E2)
private val inverseOnSurfaceDark = Color(0xFF2B3231)
private val inversePrimaryDark = Color(0xFF006A64)
private val surfaceDimDark = Color(0xFF0E1514)
private val surfaceBrightDark = Color(0xFF343A39)
private val surfaceContainerLowestDark = Color(0xFF090F0F)
private val surfaceContainerLowDark = Color(0xFF161D1C)
private val surfaceContainerDark = Color(0xFF1A2120)
private val surfaceContainerHighDark = Color(0xFF252B2A)
private val surfaceContainerHighestDark = Color(0xFF303635)


private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@Composable
actual fun getColorScheme(dynamicColor: Boolean, darkTheme: Boolean): ColorScheme =
    when {
        darkTheme -> darkScheme
        else -> lightScheme
    }
