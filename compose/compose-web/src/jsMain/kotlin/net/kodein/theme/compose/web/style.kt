package net.kodein.theme.compose.web

import net.kodein.theme.KodeinColor
import net.kodein.theme.KodeinFont
import org.jetbrains.compose.web.css.*


public val KodeinColor.Color.css: CSSColorValue get() = Color("#$rgb")

public val KodeinFont.Size.Size.em: CSSSizeValue<CSSUnit.em> get() = factor.em

public val KodeinFont.Style.FontWeight.css: Int get() = when (this) {
    KodeinFont.Style.FontWeight.Medium -> 500
    KodeinFont.Style.FontWeight.Regular -> 400
}

public val KodeinFont.Style.TextAlign.css: String get() = when (this) {
    KodeinFont.Style.TextAlign.Start -> "start"
    KodeinFont.Style.TextAlign.Center -> "center"
}

public fun CSSBuilder.apply(style: KodeinFont.Style.Style) {
    fontFamily(style.font.name)
    fontSize(style.size.em)
    fontWeight(style.weight.css)
    textAlign(style.align.css)
    letterSpacing(KodeinFont.Dimension.letterSpacing.em)
    lineHeight(KodeinFont.Dimension.lineHeight.em)
}
