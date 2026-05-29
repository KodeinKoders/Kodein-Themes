import java.util.*

plugins {
    id("net.kodein.themes.adoc")
}

kodeinThemesAdoc {
    listOf(
        "print" to "light",
        "light" to "light",
        "dark" to "dark",
    ).forEach { (theme, sourceTheme) ->

        pdf("${theme}Demo") {
            task {
                inputDir = layout.projectDirectory.dir("adocs/demo")
                outputDir = layout.buildDirectory.dir(backend.map { "asciidoctor/pdf/$theme/demo" })
            }
            kodeinTheme(theme)
        }

        html("${theme}Demo") {
            task {
                inputDir = layout.projectDirectory.dir("adocs/demo")
                outputDir = layout.buildDirectory.dir(backend.map { "asciidoctor/html/$theme/demo" })
            }
            kodeinTheme(theme)
        }

        pdf("${theme}Card") {
            task {
                inputDir = layout.projectDirectory.dir("adocs/card")
                outputDir = layout.buildDirectory.dir(backend.map { "asciidoctor/pdf/$theme/card" })
                attrs {
                    attribute("year", Calendar.getInstance().get(Calendar.YEAR))
                }
            }
            customTheme(
                baseTheme = theme,
                themesDir = layout.projectDirectory.dir("pdf-themes"),
                themeName = "card-$theme",
            )
        }

        html("${theme}Card") {
            task {
                inputDir = layout.projectDirectory.dir("adocs/card")
                outputDir = layout.buildDirectory.dir(backend.map { "asciidoctor/html/$theme/card" })
                val docinfoDir = layout.projectDirectory.dir("html-themes/docinfo")
                inputs.dir(docinfoDir)
                attrs {
                    attribute("docinfodir", docinfoDir.asFile.absolutePath)
                    attribute("docinfo", "shared")
                    attribute("year", Calendar.getInstance().get(Calendar.YEAR))
                    noFooter(true)
                }
            }
            customTheme(
                baseTheme = theme,
                themesDir = layout.projectDirectory.dir("html-themes/css"),
                themeName = "card-$theme",
            )
        }
    }
}
