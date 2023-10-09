package net.kodein.theme.compose.web

import androidx.compose.runtime.Composable
import net.kodein.theme.KodeinColor
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.kodein.compose.html.css.css


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
                height(2.em)
                marginRight(0.25.em)
            }
        }

        Span({
            css {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Start)
                height(2.em)
                color(textColor)
            }
        }) {
            Span({
                css {
                    fontSize(1.em)
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
                    fontSize(0.4.em)
                    marginTop((-0.75).em)
                    marginLeft(0.075.em)
                }
            }) {
                catchPhrase()
            }
        }
    }
}
