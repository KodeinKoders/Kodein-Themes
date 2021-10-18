package net.kodein.theme.compose.pres

import net.kodein.pres.*
import net.kodein.pres.util.d
import net.kodein.pres.util.transition
import net.kodein.theme.compose.web.Logo
import net.kodein.theme.compose.web.css
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


public data class KodeinFrameworkComponent(
    val name: String,
    val color: CSSColorValue,
    val targets: List<String> = listOf("Android", "iOS", "Web", "Server", "Desktop")
)

public fun kodeinFrameworkSlide(
    component: KodeinFrameworkComponent? = null
): Slide = Slide(
    "kodein-framework",
    stateCount = if (component != null) 3 else 2,
    config = {
        OverlayAttrs {
            style {
                if (!moveBetweenSlides) transition {
                    "background-color"(500.ms)
                }
                backgroundColor(
                    if (slideState < 2 || component == null) Color("#46AF6D")
                    else component.color
                )
            }
        }
    }

) { state ->
    Div({
        css {
            fontSize(3.5.em)
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
                Span({
                    shownIf(state < 2, Transitions.fontGrow)
                }) {
                    Text(" multiplatform")
                }
                Span({
                    hiddenIf(state < 2, Transitions.fontGrow)
                }) {
                    Text("dependency injection")
                }
            },
            section = {
                Span({
                    shownIf(state < 2, Transitions.fontGrow)
                }) {
                    Text("Framework")
                }
                Span({
                    hiddenIf(state < 2, Transitions.fontGrow)
                }) {
                    Text("DI")
                }
            }
        )
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

            d("li") {
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