package net.kodein.theme.compose.pres

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import net.kodein.pres.*
import net.kodein.pres.util.transformOrigin
import net.kodein.theme.KodeinColor
import net.kodein.theme.KodeinFont
import net.kodein.theme.compose.web.css
import net.kodein.theme.installPicon
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.kodein.cic.css
import org.w3c.dom.HTMLDivElement
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

public class KodeinAttrs(
    override val containerAttrs: AttrBuilderContext<HTMLDivElement>? = null,
    override val overlayAttrs: AttrBuilderContext<HTMLDivElement>? = null,
    public val workInProgress: Boolean = false
) : OverlayAttrs

@Composable
private fun WorkInProgress(show: Boolean, scaleFactor: Double) {
    Div({
        css {
            position(Position.Absolute)
            transform {
                scale(scaleFactor)
                rotate(45.deg)
            }
            transformOrigin("top right")
            width(22.cssRem)
            height(22.cssRem)
            top(0.em)
            right(0.em)
            transitions {
                "opacity" { duration = 1.s }
            }
        }
        style {
            opacity(if (show) 1.0 else 0.0)
        }
    }) {
        Div({
            css {
                position(Position.Absolute)
                fontSize(1.2.em)
                bottom(0.em)
                left(0.em)
                width(22.cssRem)
                textAlign("center")
                fontWeight(800)
                backgroundColor(KodeinColor.kuivre.css)
                color(Color.white)
                padding(0.1.em, 0.em)
            }
            style {
                transform {
                    translate(11.cssRem, (-11).cssRem)
                }
            }
        }) {
            Text("Work In Progress!")
        }
    }
}

public fun kodeinPres(
    nextOnClick: Boolean = false,
    slides: PresentationSlidesBuilder.() -> Unit
) {
    installPicon()

    val link = document.createElement("link") as HTMLLinkElement
    link.rel = "stylesheet"
    link.href = "style/hljs-kodein-kode.css"
    document.head!!.append(link)

    presentationAppInBody(
        enableRouter = true,
        nextOnClick = nextOnClick,
        presentationContainer = { attrs, content ->
            defaultOverlayedPresentationContainer(
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
                        "ul" {
                            textAlign("start")
                        }
                        "pre" {
                            textAlign("left")
                        }
                        "a" {
                            color(KodeinColor.orange.css)
                            textDecoration("none")
                        }

                        "h1" { header(2.6.em) }
                        "h2" { header(2.2.em) }
                        "h3" { header(1.8.em) }
                        "h4" { header(1.4.em) }
                    }
                    attrs?.invoke(this)
                },
                overlayAttrs = {
                    style {
                        transitions {
                            "background-color" { duration = slideAnimationDuration.inWholeMilliseconds.ms }
                        }
                    }
                }
            ) {
                content()
                WorkInProgress((slideConfig as? KodeinAttrs)?.workInProgress ?: false, slideScaleFactor)
                progress(Color("#651B20"))
            }
        },
        slides = slides
    )
}
