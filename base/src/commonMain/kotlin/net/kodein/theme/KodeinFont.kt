package net.kodein.theme

import net.kodein.theme.KodeinFont.Style.FontWeight.Medium
import net.kodein.theme.KodeinFont.Style.FontWeight.Regular
import net.kodein.theme.KodeinFont.Style.TextAlign.Center
import net.kodein.theme.KodeinFont.Style.TextAlign.Start
import net.kodein.theme.utils.ValueHolder
import kotlin.jvm.JvmInline


public object KodeinFont : ValueHolder<KodeinFont, KodeinFont.Font>() {
    @JvmInline
    public value class Font(public val name: String)

    public val main: Font by Font("Picon")
    public val extended: Font by Font("Picon-Extended")
    public val condensed: Font by Font("Picon-Condensed")

    public object Size : ValueHolder<Size, Size.Size>() {
        @JvmInline
        public value class Size(public val factor: Number)

        public val displayLarge: Size by Size(4)
        public val displayMedium: Size by Size(3)
        public val displaySmall: Size by Size(2)

        public val sectionTitle: Size by Size(1.5)

        public val bodyLarge: Size by Size(1.25)
        public val bodyMedium: Size by Size(1)
        public val bodySmall: Size by Size(0.8)
    }

    public object Style : ValueHolder<Style, Style.Style>() {
        public enum class FontWeight { Medium, Regular }
        public enum class TextAlign { Start, Center }
        public class Style(
            public val font: Font,
            public val size: Size.Size,
            public val weight: FontWeight,
            public val align: TextAlign
        )

        public val displayLarge: Style by Style(extended, Size.displayLarge, Medium, Center)
        public val displayMedium: Style by Style(extended, Size.displayMedium, Medium, Center)
        public val displaySmall: Style by Style(extended, Size.displaySmall, Medium, Center)

        public val sectionTitle: Style by Style(main, Size.sectionTitle, Medium, Start)

        public val focus: Style by Style(main, Size.displaySmall, Regular, Start)

        public val bodyLarge: Style by Style(main, Size.bodyLarge, Regular, Start)
        public val bodyMedium: Style by Style(main, Size.bodyMedium, Regular, Start)
        public val bodySmall: Style by Style(main, Size.bodySmall, Regular, Start)
    }

    public object Dimension {
        public const val letterSpacing: Double = 0.025
        public const val lineHeight: Double = 1.25
    }
}
