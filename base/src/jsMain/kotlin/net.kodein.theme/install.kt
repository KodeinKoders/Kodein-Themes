package net.kodein.theme

import kotlinx.browser.document
import org.w3c.dom.HTMLLinkElement


public fun installPicon() {
    val link = document.createElement("link") as HTMLLinkElement
    link.rel = "stylesheet"
    link.href = "fonts/LCTPicon.css"
    document.head!!.append(link)
}
