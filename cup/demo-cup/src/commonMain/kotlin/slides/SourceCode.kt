package slides

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import net.kodein.cup.PreparedSlide
import net.kodein.cup.isShiftPressed
import net.kodein.cup.key
import net.kodein.cup.keyevents.CupKeyEventEffect
import net.kodein.cup.sa.SAStyle
import net.kodein.cup.sa.SourceCodeBlockDebugColors
import net.kodein.cup.sa.SourceCodeThemeDebugColors
import net.kodein.cup.sa.line
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.type
import net.kodein.theme.cup.KodeinSourceCode


val sourceCode by PreparedSlide(
    stepCount = 9,
) {
    @Suppress("LocalVariableName", "RemoveCurlyBracesFromTemplate")
    val sourceCode = rememberSourceCode("kotlin") {
        val errorStyle = SAStyle.line(Color.Red, squiggle = true)

        val CmRecomputes by marker(onlyShown(3))
        val Function by marker(hidden(0))
        val CmHardWork by marker(highlighted(2))
        val CmOnlyOnce by marker(onlyShown(8))
        val Get by marker(onlyShown(0..3), highlighted(2))
        val Equal by marker(onlyShown(0..5))
        val Lazy by marker(hidden(0..3))
        val LazyH by marker(highlighted(7))
        val By by marker(hidden(0..5))
        val Error by marker(styled(errorStyle, 5))

        """
                class Universe {
                ${CmRecomputes}    // Recomputes every time!${X}
                    val answer: ${Error}Int ${Get}get() ${X}${Equal}=${X}${Lazy}${LazyH}${By}by${X} lazy${X} {${X} computeAnswer(0)${Lazy} }${X}${X}
                    private suspend fun computeAnswer(of: Int): Int {
                ${Function}        ${CmHardWork}// Hard work${CmOnlyOnce} computed only once!${X}${X}
                        println("Computing...")
                        delay(duration = 2.seconds)
                        return 42
                ${X}    }
                }
            """.trimIndent()
    }

    slideContent { step ->
        var debug by remember { mutableStateOf(0) }

        CupKeyEventEffect {
            if (it.type == KeyEventType.KeyDown && it.key == Key.R && it.isShiftPressed) {
                debug = (debug + 1) % 3
                true
            } else false
        }

        KodeinSourceCode(
            sourceCode = sourceCode,
            step = step,
            debugBlocks = if (debug == 1) SourceCodeBlockDebugColors() else null,
            printMissingThemeClasses = true,
            debugTheme = if (debug == 2) SourceCodeThemeDebugColors() else null,
        )
    }
}
