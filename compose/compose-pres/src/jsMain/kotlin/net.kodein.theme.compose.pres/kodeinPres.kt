package net.kodein.theme.compose.pres

import kotlinx.browser.document
import net.kodein.pres.PresentationSlidesBuilder
import net.kodein.pres.overlayedPresentationContainer
import net.kodein.pres.presentationAppInBody
import net.kodein.pres.progress
import net.kodein.theme.installPicon
import net.kodein.pres.util.InHeadRulesHolder
import net.kodein.pres.util.d
import net.kodein.theme.KodeinColor
import net.kodein.theme.KodeinFont
import net.kodein.theme.compose.web.KodeinStyle
import net.kodein.theme.compose.web.apply
import net.kodein.theme.compose.web.css
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.selectors.child
import org.w3c.dom.HTMLLinkElement


public object PStyle: StyleSheet(InHeadRulesHolder()) {
    internal val presentation by style {

        // Set global Slide font
        fontSize(1.5.em)
        fontFamily(KodeinFont.main.name, "sans-serif")

        // Slide theme
        backgroundColor(KodeinColor.dark.css)
        backgroundImage("url('img/logo-bg.svg')")
        backgroundRepeat("no-repeat")
        backgroundPosition("right 0 bottom -15rem")
        backgroundSize("contain")
        color(KodeinColor.cute.css)

        textAlign("center")
        d("ul") {
            textAlign("start")
        }
        d("pre") {
            textAlign("left")
        }
        d("a") {
            color(KodeinColor.dark.css)
            textDecoration("none")
        }

        d("h1") { apply(KodeinFont.Style.displayLarge) }
        d("h2") { apply(KodeinFont.Style.displayMedium) }
        d("h3") { apply(KodeinFont.Style.displaySmall) }
        d("h4") { apply(KodeinFont.Style.sectionTitle) }
        d("p") { apply(KodeinFont.Style.bodyMedium) }
    }
}
public fun kodeinPres(
    slides: PresentationSlidesBuilder.() -> Unit
) {
    installPicon()

    val link = document.createElement("link") as HTMLLinkElement
    link.rel = "stylesheet"
    link.href = "style/hljs-kodein-kode.css"
    document.head!!.append(link)

    presentationAppInBody(
        enableRouter = true,
        presentationContainer = { content ->
            overlayedPresentationContainer({
                classes(PStyle.presentation)
            }) {
                content()
                progress(Color("#651B20"))
            }
        },
        slides = slides
    )
}