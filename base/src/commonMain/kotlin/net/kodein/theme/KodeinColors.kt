package net.kodein.theme

import net.kodein.theme.utils.ValueHolder
import kotlin.jvm.JvmInline

public object KodeinColors : ValueHolder<KodeinColors, KodeinColors.Color>() {
    @JvmInline
    public value class Color(public val rgb: Int) {
        public val hex: String get() = rgb.toString(radix = 16).padStart(6, '0')
    }

    public val orange100: Color by Color(0xFDDDD6)
    public val orange200: Color by Color(0xFAC0B0)
    public val orange300: Color by Color(0xF0A698)
    public val orange400: Color by Color(0xEC7A5C)
    public val orange500: Color by Color(0xEF5E36)
    public val orange600: Color by Color(0xE84420)

    public val purple500: Color by Color(0x7A2A71)
    public val purple600: Color by Color(0x480F40)
    public val purple800: Color by Color(0x250821)

    public val Highlight: Color get() = orange100
    public val Normal: Color get() = orange300
    public val Accent: Color get() = orange600
    public val Illustration: Color get() = purple500
    public val Text: Color get() = purple600
    public val Background: Color get() = purple800

    // Rare
    public val orange050: Color by Color(0xFEF2EF)
    public val orange700: Color by Color(0xC43417)
    public val orange800: Color by Color(0x9B2510)
    public val orange900: Color by Color(0x6E180A)
    public val orange950: Color by Color(0x4A0E05)
    public val purple050: Color by Color(0xF7EEF6)
    public val purple100: Color by Color(0xE8C7E3)
    public val purple200: Color by Color(0xD9A0CF)
    public val purple300: Color by Color(0xBE72B3)
    public val purple400: Color by Color(0x9E4994)
    public val purple700: Color by Color(0x360A30)
    public val purple900: Color by Color(0x11030E)
    public val purple950: Color by Color(0x090108)
}

