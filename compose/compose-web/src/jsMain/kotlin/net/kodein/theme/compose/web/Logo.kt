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
    styleSheet: StyleSheet,
    height: CSSNumeric
) {
    Div({
        classes(styleSheet.css {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)

            fontSize(height)
            height(1.em)
        })
    }) {
        Img("img/logo/monogram-orange.svg", "Logo") {
            classes(styleSheet.css {
                height(1.em)
                marginRight(0.25.em)
            })
        }

        Span({
            classes(styleSheet.css {
                fontSize(0.5.em)
                color(KodeinColor.orange.css)
            })
        }) {
            Span({
                classes(styleSheet.css {
                    fontWeight(700)
                })
            }) {
                Text("KODEIN")
            }
            Span({
                classes(styleSheet.css {
                    fontWeight(300)
                })
            }) {
                Text("Koders")
            }
        }
    }
}