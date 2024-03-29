package net.kodein.theme

import net.kodein.theme.utils.ValueHolder
import kotlin.jvm.JvmInline

public object KodeinColors : ValueHolder<KodeinColors, KodeinColors.Color>() {
    @JvmInline
    public value class Color(public val rgb: Int) {
        public val hex: String get() = rgb.toString(radix = 16).padStart(6, '0')
    }

    // Primary
    public val orange: Color by Color(0xE8441F)
    public val purple: Color by Color(0x921F81)

    // Secondary
    public val light: Color by Color(0xF7E1DE)
    public val dark: Color by Color(0x240821)
    public val darker: Color by Color(0x120411)

    // Tertiary
    public val byzantium: Color by Color(0x480F40)
    public val zinzolin: Color by Color(0x6D1761)
    public val amethyst: Color by Color(0xB35C9D)
    public val glycine: Color by Color(0xD39AB8)
    public val salmon: Color by Color(0xF0A698)
    public val coral: Color by Color(0xEC755B)
    public val copper: Color by Color(0xA6301F)
    public val rust: Color by Color(0x651B20)

    /*
               Darker
                Dark
     Byzantium        Rust
     Zinzolin         Copper
 Purple                   Orange
     Amethyst         Coral
     Glycine          Salmon
               Light
    */

    public val dark_purple: Color get() = byzantium
    public val dark_orange: Color get() = rust

    public val orange_dark: Color get() = copper
    public val orange_light: Color get() = coral

    public val light_orange: Color get() = salmon
    public val light_purple: Color get() = glycine

    public val purple_light: Color get() = amethyst
    public val purple_dark: Color get() = zinzolin
}

