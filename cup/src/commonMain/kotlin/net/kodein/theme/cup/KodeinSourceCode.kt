package net.kodein.theme.cup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeDebugColors
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.JetBrainsMono


@Composable
public fun KodeinSourceCode(
    sourceCode: SourceCode,
    step: Int = 0,
    modifier: Modifier = Modifier,
    file: String? = null,
    fontSize: TextUnit = TextUnit.Unspecified,
    style: TextStyle = TextStyle(),
    debug: Boolean = false
) {
    val mergedStyle = TextStyle(fontFamily = JetBrainsMono, fontSize = 12.sp) + style + TextStyle(fontSize = fontSize)
    Column {
        if (file != null) {
            Text(
                text = file,
                color = Color(KodeinColors.purple_light),
                style = mergedStyle
            )
        }
        SourceCode(
            sourceCode = sourceCode,
            step = step,
            style = mergedStyle,
            theme = KodeinSourceCodeTheme,
            debug = if (debug) SourceCodeDebugColors() else null,
            modifier = modifier
                .background(Color.DarkGray, RoundedCornerShape(4.dp))
                .padding(8.dp)
        )
    }
}
