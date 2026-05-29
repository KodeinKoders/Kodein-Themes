package net.kodein.theme.cup

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import net.kodein.cup.sa.SourceCodeTheme
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color


public val KodeinDarkSourceCodeTheme: SourceCodeTheme = { cls ->
    when (cls) {
        "default",
        "params",
        -> SpanStyle(
            color = Color(KodeinColors.purple100),
            fontWeight = FontWeight.Normal,
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
        "class",
        -> SpanStyle(
            color = Color(KodeinColors.orange300),
            fontWeight = FontWeight.Normal,
        )

        "keyword",
        "selector-tag",
        "section",
        "attribute",
        "name",
        "variable",
        "function",
        -> SpanStyle(
            color = Color(KodeinColors.purple300),
            fontWeight = FontWeight.Bold,
        )

        "bullet",
        "quote",
        "link",
        "number",
        "regexp",
        "literal",
        "string",
        -> SpanStyle(
            color = Color(KodeinColors.purple200),
        )

        "comment",
        "deletion",
        "meta",
        -> SpanStyle(
            color = Color(KodeinColors.orange600),
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

public val KodeinLightSourceCodeTheme: SourceCodeTheme = { cls ->
    when (cls) {
        "default",
        "params",
            -> SpanStyle(
            color = Color(KodeinColors.purple800),
            fontWeight = FontWeight.Normal,
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
        "class",
            -> SpanStyle(
            color = Color(KodeinColors.orange900),
            fontWeight = FontWeight.Normal,
        )

        "keyword",
        "selector-tag",
        "section",
        "attribute",
        "name",
        "variable",
        "function",
            -> SpanStyle(
            color = Color(KodeinColors.purple500),
            fontWeight = FontWeight.Bold,
        )

        "bullet",
        "quote",
        "link",
        "number",
        "regexp",
        "literal",
        "string",
            -> SpanStyle(
            color = Color(KodeinColors.purple300),
        )

        "comment",
        "deletion",
        "meta",
            -> SpanStyle(
            color = Color(KodeinColors.orange600),
        )

        "strong",
            -> SpanStyle(
            color = Color(KodeinColors.orange900),
            fontWeight = FontWeight.Bold
        )

        "emphasis",
            -> SpanStyle(
            color = Color(KodeinColors.orange900),
            fontStyle = FontStyle.Italic,
            fontSynthesis = FontSynthesis.Style,
        )

        else -> null
    }
}
