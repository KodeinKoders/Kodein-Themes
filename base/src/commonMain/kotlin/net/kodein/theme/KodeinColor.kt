package net.kodein.theme

import net.kodein.theme.utils.ValueHolder
import kotlin.jvm.JvmInline

public object KodeinColor : ValueHolder<KodeinColor, KodeinColor.Color>() {
    @JvmInline
    public value class Color(public val rgb: String)

    /*
                   Darker
                    Dark
         kyzantium       krouille
         kinzolin        kuivre
      purple                orange
         kamethiste      korail
         klycine         kaumon
                    Cute
     */

    // Primarykyzantium
    public val orange: Color by Color("E8441F")
    public val purple: Color by Color("921F81")

    // Secondary
    public val cute: Color by Color("F7E1DE")
    public val dark: Color by Color("240821")
    public val darker: Color by Color("120411")

    // Tertiary
    public val kyzantium: Color by Color("480F40")
    public val kinzolin: Color by Color("6D1761")
    public val kamethiste: Color by Color("B35C9D")
    public val klycine: Color by Color("D39AB8")
    public val kaumon: Color by Color("F0A698")
    public val korail: Color by Color("EC755B")
    public val kuivre: Color by Color("A6301F")
    public val krouille: Color by Color("651B20")
}
