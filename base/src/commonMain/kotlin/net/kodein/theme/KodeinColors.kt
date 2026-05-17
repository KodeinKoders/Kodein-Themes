package net.kodein.theme

import net.kodein.theme.utils.ValueHolder
import kotlin.jvm.JvmInline
import kotlin.math.roundToInt

public object KodeinColors : ValueHolder<KodeinColors, KodeinColors.Color>() {
    @JvmInline
    public value class Color(public val rgb: Int) {
        public constructor(red: Float, green: Float, blue: Float) : this(
                ((red * 255).roundToInt() shl 16)
            or  ((green * 255).roundToInt() shl 8)
            or ((blue * 255).roundToInt())
        )

        public val hex: String get() = rgb.toString(radix = 16).padStart(6, '0')
        public val red: Float get() = ((rgb shr 16) and 0xFF).toFloat() / 255f
        public val green: Float get() = ((rgb shr 8) and 0xFF).toFloat() / 255f
        public val blue: Float get() = (rgb and 0xFF).toFloat() / 255f
    }

    private fun lerp(start: Float, stop: Float, fraction: Float): Float {
        return (1 - fraction) * start + fraction * stop
    }

    private fun lerp(start: Color, stop: Color, fraction: Float): Color {
//        println("${start.hex}: ${start.red} > ${stop.hex}: ${stop.red} = ${lerp(start.red, stop.red, fraction)}")
        return Color(
            red = lerp(start.red, stop.red, fraction),
            green = lerp(start.green, stop.green, fraction),
            blue = lerp(start.blue, stop.blue, fraction),
        )
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

    // Computed
    public val orange075: Color by lerp(orange050, orange100, 0.5f)
    public val orange125: Color by lerp(orange100, orange200, 0.25f)
    public val orange150: Color by lerp(orange100, orange200, 0.5f)
    public val orange175: Color by lerp(orange100, orange200, 0.75f)
    public val orange225: Color by lerp(orange200, orange300, 0.25f)
    public val orange250: Color by lerp(orange200, orange300, 0.5f)
    public val orange275: Color by lerp(orange200, orange300, 0.75f)
    public val orange325: Color by lerp(orange300, orange400, 0.25f)
    public val orange350: Color by lerp(orange300, orange400, 0.5f)
    public val orange375: Color by lerp(orange300, orange400, 0.75f)
    public val orange425: Color by lerp(orange400, orange500, 0.25f)
    public val orange450: Color by lerp(orange400, orange500, 0.5f)
    public val orange475: Color by lerp(orange400, orange500, 0.75f)
    public val orange525: Color by lerp(orange500, orange600, 0.25f)
    public val orange550: Color by lerp(orange500, orange600, 0.5f)
    public val orange575: Color by lerp(orange500, orange600, 0.75f)
    public val orange625: Color by lerp(orange600, orange700, 0.25f)
    public val orange650: Color by lerp(orange600, orange700, 0.5f)
    public val orange675: Color by lerp(orange600, orange700, 0.25f)
    public val orange725: Color by lerp(orange700, orange800, 0.25f)
    public val orange750: Color by lerp(orange700, orange800, 0.5f)
    public val orange775: Color by lerp(orange700, orange800, 0.75f)
    public val orange825: Color by lerp(orange800, orange900, 0.25f)
    public val orange850: Color by lerp(orange800, orange900, 0.5f)
    public val orange875: Color by lerp(orange800, orange900, 0.75f)
    public val orange925: Color by lerp(orange900, orange950, 0.5f)

    public val purple075: Color by lerp(purple050, purple100, 0.5f)
    public val purple125: Color by lerp(purple100, purple200, 0.25f)
    public val purple150: Color by lerp(purple100, purple200, 0.5f)
    public val purple175: Color by lerp(purple100, purple200, 0.75f)
    public val purple225: Color by lerp(purple200, purple300, 0.25f)
    public val purple250: Color by lerp(purple200, purple300, 0.5f)
    public val purple275: Color by lerp(purple200, purple300, 0.75f)
    public val purple325: Color by lerp(purple300, purple400, 0.25f)
    public val purple350: Color by lerp(purple300, purple400, 0.5f)
    public val purple375: Color by lerp(purple300, purple400, 0.75f)
    public val purple425: Color by lerp(purple400, purple500, 0.25f)
    public val purple450: Color by lerp(purple400, purple500, 0.5f)
    public val purple475: Color by lerp(purple400, purple500, 0.75f)
    public val purple525: Color by lerp(purple500, purple600, 0.25f)
    public val purple550: Color by lerp(purple500, purple600, 0.5f)
    public val purple575: Color by lerp(purple500, purple600, 0.75f)
    public val purple625: Color by lerp(purple600, purple700, 0.25f)
    public val purple650: Color by lerp(purple600, purple700, 0.5f)
    public val purple675: Color by lerp(purple600, purple700, 0.75f)
    public val purple725: Color by lerp(purple700, purple800, 0.25f)
    public val purple750: Color by lerp(purple700, purple800, 0.5f)
    public val purple775: Color by lerp(purple700, purple800, 0.75f)
    public val purple825: Color by lerp(purple800, purple900, 0.25f)
    public val purple850: Color by lerp(purple800, purple900, 0.5f)
    public val purple875: Color by lerp(purple800, purple900, 0.75f)
    public val purple925: Color by lerp(purple900, purple950, 0.5f)
}

