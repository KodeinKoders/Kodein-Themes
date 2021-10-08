package net.kodein.theme.compose.web

import net.kodein.theme.KodeinColor
import net.kodein.theme.KodeinFont
import org.jetbrains.compose.web.css.*


private val letterSpacing = KodeinFont.Dimension.letterSpacing.em
private val lineHeight = KodeinFont.Dimension.lineHeight.em

public val KodeinColor.Color.css: CSSColorValue get() = Color("#$rgb")

public val KodeinFont.Size.Size.rem: CSSSizeValue<CSSUnit.rem> get() = factor.cssRem

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
    fontSize(style.size.rem)
    fontWeight(style.weight.css)
    textAlign(style.align.css)
    letterSpacing(letterSpacing)
    lineHeight(lineHeight)
}

public object KodeinStyle : StyleSheet() {
    public val displayLarge: String by style { apply(KodeinFont.Style.displayLarge) }
    public val displayMedium: String by style { apply(KodeinFont.Style.displayMedium) }
    public val displaySmall: String by style { apply(KodeinFont.Style.displaySmall) }

    public val sectionTitle: String by style { apply(KodeinFont.Style.sectionTitle) }

    public val focus: String by style { apply(KodeinFont.Style.focus) }

    public val bodyLarge: String by style { apply(KodeinFont.Style.displayLarge) }
    public val bodyMedium: String by style { apply(KodeinFont.Style.displayMedium) }
    public val bodySmall: String by style { apply(KodeinFont.Style.displaySmall) }
}
