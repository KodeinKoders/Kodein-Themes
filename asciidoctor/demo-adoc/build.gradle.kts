import java.util.*

plugins {
    id("net.kodein.themes.adoc")
}

asciidoctor {

    listOf(
        "print" to "light",
        "light" to "light",
        "dark" to "dark",
    ).forEach { (theme, sourceTheme) ->

        directory(
            directory = layout.projectDirectory.dir("adocs/demo"),
            name = "${theme}Demo"
        ) {
            pdf { kodeinTheme(theme) }
            html { kodeinTheme(theme) }
        }

        directory(
            directory = layout.projectDirectory.dir("adocs/card"),
            name = "${theme}Card",
        ) {
            pdf {
                customTheme(
                    baseTheme = theme,
                    themesDir = layout.projectDirectory.dir("pdf-themes"),
                    themeName = "card-$theme",
                )
            }
            html {
                customTheme(
                    baseTheme = theme,
                    themesDir = layout.projectDirectory.dir("html-themes/css"),
                    themeName = "card-$theme",
                )
                backend {
                    val docinfoDir = layout.projectDirectory.dir("html-themes/docinfo")
                    inputs.dir(docinfoDir)
                    attrs {
                        attribute("docinfodir", docinfoDir.asFile.absolutePath)
                        attribute("docinfo", "shared")
                        noFooter(true)
                    }
                }
            }
            backends.forEach {
                it.backend {
                    attrs {
                        attribute("year", Calendar.getInstance().get(Calendar.YEAR))
                    }
                }
            }
        }
    }
}
