package net.kodein.theme.compose.pres

import net.kodein.theme.compose.web.Logo
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.flex
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.listStyleType
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.opacity
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.transform
import org.jetbrains.compose.web.css.transitions
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul
import org.kodein.compose.html.css.css
import org.kodein.compose.html.pres.OverlayAttrs
import org.kodein.compose.html.pres.Slide


public data class KodeinOpenSourceComponent(
    val name: String,
    val usage: String,
    val color: CSSColorValue,
    val targets: List<String> = listOf("Android", "iOS", "Web", "Server", "Desktop")
)

public fun kodeinOpenSourceSlide(
    component: KodeinOpenSourceComponent? = null
): Slide = Slide(
    "kodein-open-source",
    stateCount = if (component != null) 3 else 2,
    config = {
        OverlayAttrs {
            style {
                if (!moveBetweenSlides) {
                    transitions {
                        "background-color" { duration = 1.s }
                    }
                }
                backgroundColor(
                    if (slide.state < 2 || component == null) Color("#46AF6D")
                    else component.color
                )
            }
        }
    }

) { state ->
    Div({
        css {
            fontSize(3.5.em)
            position(Position.Relative)
        }
    }) {
        Div({
            css {
                transitions {
                    "opacity" { duration = 1.s }
                    "transform" { duration = 1.s }
                }
            }
            style {
                if (state >= 2) {
                    opacity(0)
                    transform {
                        translateY((-1).em)
                    }
                }
            }
        }) {
            Logo(
                monogramColor = "white",
                textColor = Color.white,
                catchPhrase = {
                    Text("painless ")
                    Img(
                        src = "img/kotlin.svg",
                        alt = "Kotlin"
                    ) {
                        css {
                            height(0.55.em)
                        }
                    }
                    Text(" multiplatform")
                },
                section = {
                    Text("OpenSource")
                }
            )
        }
        Div({
            css {
                transitions {
                    "opacity" { duration = 1.s }
                    "transform" { duration = 1.s }
                }
                position(Position.Absolute)
                top((-0.5).em)
                left(0.em)
                width(100.percent)
                height(2.em)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)
                color(Color.white)
            }
            style {
                if (state < 2) {
                    opacity(0)
                    transform {
                        translateY(1.em)
                    }
                }
            }
        }) {
            Span {
                Text(component?.name ?: "???")
            }
            Span({
                css {
                    fontSize(0.4.em)
                    marginTop((-0.75).em)
                }
            }) {
                Text("painless ")
                Img(
                    src = "img/kotlin.svg",
                    alt = "Kotlin"
                ) {
                    css {
                        height(0.55.em)
                    }
                }
                Text(" ${component?.usage ?: "???"}")
            }
        }
    }

    Ul({
        css {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.SpaceBetween)
            alignItems(AlignItems.Center)
            width(90.percent)
            marginTop(3.em)
            padding(0.em)

            "li" {
                listStyleType("none")
                margin(0.5.em)
                padding(0.6.em, 0.em, 0.4.em, 0.em)
                textAlign("center")
                backgroundColor(Color.silver)
                color(Color.black)
                flex(1, 0.em)
                borderRadius(0.5.em)
                transitions {
                    "box-shadow" { duration = 500.ms }
                    "opacity" { duration = 500.ms }
                }
            }

            transitions {
                "height" { duration = 500.ms }
                "opacity" { duration = 500.ms }
            }
            height(3.5.em)
        }
        style {
            if (state < 1) {
                opacity(0)
                height(0.em)
            }
        }
    }) {
        for (target in listOf("Android", "iOS", "Web", "Server", "Desktop")) {
            Li({
                style {
                    if (state >= 2 && component != null) {
                        if (target in component.targets) property("box-shadow", "0 0 1.5em black")
                        else opacity(0.3)
                    }
                }
            }) { Text(target) }
        }
    }
}