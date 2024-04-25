package net.kodein.theme.cup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.sa.SourceCode
import net.kodein.theme.compose.JetBrainsMono
import net.kodein.theme.compose.JetBrainsMonoNL


@Composable
public fun KodeinSourceCode(
    sourceCode: SourceCode,
    step: Int = 0,
    style: TextStyle = TextStyle(),
    modifier: Modifier = Modifier
) {
    SourceCode(
        sourceCode = sourceCode,
        step = step,
        style = TextStyle(fontFamily = JetBrainsMono, fontSize = 12.sp) + style,
        theme = KodeinSourceCodeTheme,
        modifier = modifier
            .background(Color.DarkGray, RoundedCornerShape(4.dp))
            .padding(8.dp)
    )
}
