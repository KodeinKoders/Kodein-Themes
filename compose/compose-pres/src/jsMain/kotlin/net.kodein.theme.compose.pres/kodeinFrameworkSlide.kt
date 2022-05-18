package net.kodein.theme.compose.pres

import net.kodein.pres.*
import net.kodein.pres.util.transition
import net.kodein.theme.compose.web.Logo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.kodein.cic.css


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
                if (!moveBetweenSlides) transition {
                    "background-color"(1.s)
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
                transition {
                    "opacity"(1.s)
                    "transform"(1.s)
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
                transition {
                    "opacity"(1.s)
                    "transform"(1.s)
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
                transition {
                    "box-shadow"(500.ms)
                    "opacity"(500.ms)
                }
            }

            transition {
                "height"(500.ms)
                "opacity"(500.ms)
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