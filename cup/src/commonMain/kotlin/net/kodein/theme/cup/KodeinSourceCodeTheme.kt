package net.kodein.theme.cup

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import net.kodein.cup.sa.SourceCodeTheme
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color


public val KodeinSourceCodeTheme: SourceCodeTheme = { cls ->
    when (cls) {
        "default",
        "class",
        "params",
        -> SpanStyle(
            color = Color(KodeinColors.orange100)
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
        "function",
        -> SpanStyle(
            color = Color(KodeinColors.orange300)
        )

        "keyword",
        "selector-tag",
        "section",
        "attribute",
        "name",
        "variable",
        -> SpanStyle(
            color = Color(KodeinColors.orange600)
        )

        "bullet",
        "quote",
        "link",
        "number",
        "regexp",
        "literal",
        "string",
        -> SpanStyle(
            color = Color(KodeinColors.purple200)
        )

        "comment",
        "deletion",
        "meta",
        -> SpanStyle(
            color = Color(KodeinColors.purple400)
        )

        "strong",
        -> SpanStyle(
            color = Color(KodeinColors.orange300),
            fontWeight = FontWeight.Bold
        )

        "emphasis",
        -> SpanStyle(
            color = Color(KodeinColors.orange300),
            fontStyle = FontStyle.Italic,
            fontSynthesis = FontSynthesis.Style,
        )

        else -> null
    }
}
