package net.kodein.theme.cup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeBlockDebugColors
import net.kodein.cup.sa.SourceCodeThemeDebugColors
import net.kodein.theme.compose.JetBrainsMono


@Composable
public fun KodeinSourceCode(
    sourceCode: SourceCode,
    step: Int = 0,
    modifier: Modifier = Modifier,
    file: String? = null,
    fontSize: TextUnit = TextUnit.Unspecified,
    style: TextStyle = TextStyle(),
    debugBlocks: SourceCodeBlockDebugColors? = null,
    printMissingThemeClasses: Boolean = false,
    debugTheme: SourceCodeThemeDebugColors? = null,
) {
    val mergedStyle = TextStyle(fontFamily = JetBrainsMono, fontSize = 12.sp) + style + TextStyle(fontSize = fontSize)
    Column(modifier) {
        if (file != null) {
            Text(
                text = file,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = mergedStyle
            )
        }
        val luminance = MaterialTheme.colorScheme.tertiaryContainer.luminance()
        SourceCode(
            sourceCode = sourceCode,
            step = step,
            style = mergedStyle,
            theme = if (luminance <= .5f) KodeinDarkSourceCodeTheme else KodeinLightSourceCodeTheme,
            debugBlocks = debugBlocks,
            printMissingThemeClasses = printMissingThemeClasses,
            debugTheme = debugTheme,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer, RoundedCornerShape(16.dp))
                .padding(8.dp)
        )
    }
}
