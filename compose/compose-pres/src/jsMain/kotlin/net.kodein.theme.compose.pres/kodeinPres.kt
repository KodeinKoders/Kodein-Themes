package net.kodein.theme.compose.pres

import kotlinx.browser.document
import net.kodein.pres.PresentationSlidesBuilder
import net.kodein.pres.overlayedPresentationContainer
import net.kodein.pres.presentationAppInBody
import net.kodein.pres.progress
import net.kodein.pres.util.d
import net.kodein.pres.util.transition
import net.kodein.theme.KodeinColor
import net.kodein.theme.KodeinFont
import net.kodein.theme.compose.web.apply
import net.kodein.theme.compose.web.css
import net.kodein.theme.compose.web.em
import net.kodein.theme.installPicon
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.w3c.dom.HTMLLinkElement


private fun CSSBuilder.header(size: CSSSizeValue<CSSUnit.em>) {
    fontFamily(KodeinFont.extended.name)
    fontSize(size)
    margin(0.4.em)
    fontWeight(KodeinFont.Style.FontWeight.Medium.css)
    textAlign("center")
    letterSpacing(KodeinFont.Dimension.letterSpacing.em)
//    lineHeight(KodeinFont.Dimension.lineHeight.em)
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
            overlayedPresentationContainer(
                containerAttrs = {
                    css {
                        // Set global Slide font
                        fontSize(1.5.em)
                        fontFamily(KodeinFont.main.name, "sans-serif")
                        fontWeight(KodeinFont.Style.FontWeight.Regular.css)
                        textAlign("start")

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

                        d("h1") { header(2.6.em) }
                        d("h2") { header(2.2.em) }
                        d("h3") { header(1.8.em) }
                        d("h4") { header(1.4.em) }
                    }
                },
                overlayAttrs = {
                    style {
                        transition { "background-color"(slideAnimationDuration.inWholeMilliseconds.ms) }
                    }
                }
            ) {
                content()
                progress(Color("#651B20"))
            }
        },
        slides = slides
    )
}
