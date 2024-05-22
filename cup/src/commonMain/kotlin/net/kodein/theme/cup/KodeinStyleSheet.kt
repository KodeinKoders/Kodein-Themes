package net.kodein.theme.cup

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import net.kodein.cup.ui.SpanStyleSheet
import net.kodein.cup.ui.styled
import net.kodein.theme.compose.JetBrainsMono


public abstract class KodeinStyleSheet : SpanStyleSheet() {
    /** Light */
    public val l: Marker by registerMarker(SpanStyle(fontWeight = FontWeight.Light))
    /** Normal */
    public val n: Marker by registerMarker(SpanStyle(fontWeight = FontWeight.Normal))
    /** Medium */
    public val m: Marker by registerMarker(SpanStyle(fontWeight = FontWeight.Medium))

    public companion object : KodeinStyleSheet()
}

public class ComposeKodeinStyleSheet(
    private val jetBrainsMono: FontFamily
) : KodeinStyleSheet() {
    /** Source Code */
    public val sc: Marker by registerMarker(SpanStyle(fontFamily = jetBrainsMono))
}

public fun kStyled(build: KodeinStyleSheet.() -> String): AnnotatedString =
    styled(KodeinStyleSheet, build)

@Composable
public fun kcStyled(build: ComposeKodeinStyleSheet.() -> String): AnnotatedString =
    styled(ComposeKodeinStyleSheet(JetBrainsMono), build)
