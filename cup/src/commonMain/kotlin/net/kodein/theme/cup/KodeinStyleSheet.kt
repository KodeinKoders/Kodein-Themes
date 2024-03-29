package net.kodein.theme.cup

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import org.kodein.pres.ui.SpanStyleSheet
import org.kodein.pres.ui.styled


public object KodeinStyleSheet : SpanStyleSheet() {
    /** Light */
    public val l: Marker by registerMarker(SpanStyle(fontWeight = FontWeight.Light))
    /** Normal */
    public val n: Marker by registerMarker(SpanStyle(fontWeight = FontWeight.Normal))
    /** Medium */
    public val m: Marker by registerMarker(SpanStyle(fontWeight = FontWeight.Medium))
}

public fun kStyled(build: KodeinStyleSheet.() -> String): AnnotatedString = styled(KodeinStyleSheet, build)