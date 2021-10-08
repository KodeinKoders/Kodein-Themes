package net.kodein.theme.compose.web

import androidx.compose.runtime.Composable
import net.kodein.theme.KodeinColor
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text


@Composable
public fun Logo(
    section: String,
    color: KodeinColor.Color = KodeinColor.orange,
    content: @Composable () -> Unit
) {
    Logo(
        section = section,
        monogramColor = KodeinColor.nameOf(color),
        textColor = color.css,
        content = content
    )
}

@Composable
public fun Logo(
    section: String,
    monogramColor: String,
    textColor: CSSColorValue,
    content: @Composable () -> Unit
) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            height(1.em)
        }
    }) {
        Img("img/logo/monogram-$monogramColor.svg", "Logo") {
            style {
                height(1.em)
                marginRight(0.25.em)
            }
        }

        Span({
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Start)
                height(1.em)
                color(textColor)
            }
        }) {
            Span({
                style {
                    fontSize(0.5.em)
                    fontWeight(700)
                }
            }) {
                Text("KODEIN")
                Span({
                    style {
                        fontWeight(300)
                    }
                }) {
                    Text(section)
                }
            }
            Span({
                style {
                    fontSize(0.2.em)
                    marginTop((-0.75).em)
                    marginLeft(0.075.em)
                }
            }) {
                content()
            }
        }
    }
}