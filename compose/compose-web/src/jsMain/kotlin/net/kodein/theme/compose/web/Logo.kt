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
    color: KodeinColor.Color = KodeinColor.orange,
    catchPhrase: @Composable () -> Unit = {},
    section: @Composable () -> Unit
) {
    Logo(
        monogramColor = KodeinColor.nameOf(color),
        textColor = color.css,
        section = section,
        catchPhrase = catchPhrase
    )
}

@Composable
public fun Logo(
    monogramColor: String,
    textColor: CSSColorValue,
    catchPhrase: @Composable () -> Unit = {},
    section: @Composable () -> Unit
) {
    Div({
        css {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            height(1.em)
        }
    }) {
        Img("img/logo/monogram-$monogramColor.svg", "Logo") {
            css {
                height(1.em)
                marginRight(0.25.em)
            }
        }

        Span({
            css {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Start)
                height(1.em)
                color(textColor)
            }
        }) {
            Span({
                css {
                    fontSize(0.5.em)
                    fontWeight(700)
                }
            }) {
                Text("KODEIN")
                Span({
                    css {
                        fontWeight(300)
                    }
                }) {
                    section()
                }
            }
            Span({
                css {
                    fontSize(0.2.em)
                    marginTop((-0.75).em)
                    marginLeft(0.075.em)
                }
            }) {
                catchPhrase()
            }
        }
    }
}
