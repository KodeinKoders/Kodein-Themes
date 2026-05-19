package slides

import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.theme.cup.KodeinSourceCode


val SourceCode by Slide {

    KodeinSourceCode(
        sourceCode = rememberSourceCode(
            language = "kotlin",
        ) {
            // language="kotlin"
            """
                // Kotlin example
                fun helloWorld() {
                    println("Hello World")
                }
            """.trimIndent()
        }
    )

}