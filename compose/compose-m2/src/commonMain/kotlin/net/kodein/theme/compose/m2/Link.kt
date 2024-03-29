package net.kodein.theme.compose.m2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle


@Composable
public fun Link(
    uri: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable {
                uriHandler.openUri(uri)
            }
    ) {
        ProvideTextStyle(TextStyle(color = MaterialTheme.colors.primary)) {
            content()
        }
    }
}

@Composable
public fun Link(
    text: String,
    uri: String,
    modifier: Modifier = Modifier
) {
    Link(
        uri = uri,
        modifier = modifier,
        content = { Text(text) }
    )
}
