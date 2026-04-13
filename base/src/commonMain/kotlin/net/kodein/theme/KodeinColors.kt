package net.kodein.theme

import net.kodein.theme.utils.ValueHolder
import kotlin.jvm.JvmInline

public object KodeinColors : ValueHolder<KodeinColors, KodeinColors.Color>() {
    @JvmInline
    public value class Color(public val rgb: Int) {
        public val hex: String get() = rgb.toString(radix = 16).padStart(6, '0')
    }

    /*
                Darker
                 Dark
     dark_purple     dark_orange
     purple_dark     orange_dark
 Purple                  Orange
     purple_light    orange_light
     light_purple    light_orange
                Light
    */

    // Primary
    public val orange: Color by Color(0xE8441F)
    public val purple: Color by Color(0x921F81)

    // Secondary
    public val lighter: Color by Color(0xFBF0EF)
    public val light: Color by Color(0xF7E1DE)
    public val dark: Color by Color(0x240821)
    public val darker: Color by Color(0x120411)

    // Tertiary
    public val dark_purple: Color by Color(0x480F40)
    public val purple_dark: Color by Color(0x6D1761)
    public val purple_light: Color by Color(0xB35C9D)
    public val light_purple: Color by Color(0xD39AB8)
    public val light_orange: Color by Color(0xF0A698)
    public val orange_light: Color by Color(0xEC755B)
    public val orange_dark: Color by Color(0xA6301F)
    public val dark_orange: Color by Color(0x651B20)

    // Error
    public val error: Color by Color(0xAA0000)
    public val onError: Color by Color(0xFFCCCC)
}

