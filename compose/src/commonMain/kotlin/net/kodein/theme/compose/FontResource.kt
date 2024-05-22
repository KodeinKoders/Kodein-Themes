package net.kodein.theme.compose

import org.jetbrains.compose.resources.FontResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.ResourceItem


@OptIn(InternalResourceApi::class)
internal fun FontResource(file: String): FontResource {
    val id = file.split('/').last().removeSuffix(".ttf").replace('-', '_')
    return FontResource(
        id = "font:$id",
        items = setOf(
            ResourceItem(
                qualifiers = emptySet(),
                path = file,
                offset = -1,
                size = -1
            )
        )
    )
}