package net.kodein.theme.cup

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.kodein.pres.sa.SourceCodeTheme


public val KodeinSourceCodeTheme: SourceCodeTheme = { cls ->
    when (cls) {
        "default"
        -> SpanStyle(
            color = Color(0xFF_F7E1DE)
        )

        "code",
        "selector-class",
        "subst",
        "type",
        "built_in",
        "builtin-name",
        "symbol",
        "selector-id",
        "selector-attr",
        "selector-pseudo",
        "template-tag",
        "template-variable",
        "addition",
        "title",
        -> SpanStyle(
            color = Color(0xFF_F0A698)
        )

        "keyword",
        "selector-tag",
        "section",
        "attribute",
        "name",
        "variable",
        -> SpanStyle(
            color = Color(0xFF_EC755B)
        )

        "bullet",
        "quote",
        "link",
        "number",
        "regexp",
        "literal",
        "string",
        -> SpanStyle(
            color = Color(0xFF_D39AB8)
        )

        "comment",
        "deletion",
        "meta",
        -> SpanStyle(
            color = Color(0xFF_B35C9D)
        )

        "strong",
        -> SpanStyle(
            color = Color(0xFF_F0A698),
            fontWeight = FontWeight.Bold
        )

        "emphasis",
        -> SpanStyle(
            color = Color(0xFF_F0A698),
            fontStyle = FontStyle.Italic
        )

        else -> null
    }
}
