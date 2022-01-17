/*
https://github.com/JetBrains/compose-jb/issues/1207
*/
package net.kodein.theme.compose.web.util

import kotlinx.browser.document
import org.jetbrains.compose.web.css.*
import org.w3c.dom.HTMLStyleElement
import org.w3c.dom.css.*

private external class CSSKeyframesRule: CSSRule {
    val cssRules: CSSRuleList
}

private inline fun CSSKeyframesRule.appendRule(cssRule: String) {
    this.asDynamic().appendRule(cssRule)
}

private fun clearCSSRules(sheet: CSSStyleSheet) {
    repeat(sheet.cssRules.length) {
        sheet.deleteRule(0)
    }
}

private fun setCSSRules(sheet: CSSStyleSheet, cssRules: CSSRuleDeclarationList) {
    cssRules.forEach { cssRule ->
        sheet.addRule(cssRule)
    }
}

private fun CSSStyleSheet.addRule(cssRule: String): CSSRule? {
    val cssRuleIndex = this.insertRule(cssRule, this.cssRules.length)
    return this.cssRules.item(cssRuleIndex)
}

private fun CSSKeyframesRule.addRule(cssRule: String): CSSRule? {
    appendRule(cssRule)
    return this.cssRules.item(this.cssRules.length - 1)
}

private fun CSSStyleSheet.addRule(cssRuleDeclaration: CSSRuleDeclaration) {
    addRule("${cssRuleDeclaration.header} {}")?.let { cssRule ->
        fillRule(cssRuleDeclaration, cssRule)
    }
}

private fun CSSGroupingRule.addRule(cssRule: String): CSSRule? {
    val cssRuleIndex = this.insertRule(cssRule, this.cssRules.length)
    return this.cssRules.item(cssRuleIndex)
}

private fun CSSGroupingRule.addRule(cssRuleDeclaration: CSSRuleDeclaration) {
    addRule("${cssRuleDeclaration.header} {}")?.let { cssRule ->
        fillRule(cssRuleDeclaration, cssRule)
    }
}

private fun CSSKeyframesRule.addRule(cssRuleDeclaration: CSSKeyframeRuleDeclaration) {
    addRule("${cssRuleDeclaration.header} {}")?.let { cssRule ->
        fillRule(cssRuleDeclaration, cssRule)
    }
}

private fun fillRule(
    cssRuleDeclaration: CSSRuleDeclaration,
    cssRule: CSSRule
) {
    when (cssRuleDeclaration) {
        is CSSStyledRuleDeclaration -> {
            val cssStyleRule = cssRule.unsafeCast<CSSStyleRule>()
            cssRuleDeclaration.style.properties.forEach { (name, value) ->
                setProperty(cssStyleRule.style, name, value)
            }
            cssRuleDeclaration.style.variables.forEach { (name, value) ->
                setVariable(cssStyleRule.style, name, value)
            }
        }
        is CSSGroupingRuleDeclaration -> {
            val cssGroupingRule = cssRule.unsafeCast<CSSGroupingRule>()
            cssRuleDeclaration.rules.forEach { childRuleDeclaration ->
                cssGroupingRule.addRule(childRuleDeclaration)
            }
        }
        is CSSKeyframesRuleDeclaration -> {
            val cssGroupingRule = cssRule.unsafeCast<CSSKeyframesRule>()
            cssRuleDeclaration.keys.forEach { childRuleDeclaration ->
                cssGroupingRule.addRule(childRuleDeclaration)
            }
        }
    }
}

private fun setProperty(
    style: CSSStyleDeclaration,
    name: String,
    value: StylePropertyValue
) {
    style.setProperty(name, value.toString())
}

private fun setVariable(
    style: CSSStyleDeclaration,
    name: String,
    value: StylePropertyValue
) {
    style.setProperty("--$name", value.toString())
}

public class InHeadRulesHolder : CSSRulesHolder {
    private val style: HTMLStyleElement = document.createElement("style") as HTMLStyleElement
    private val rules = ArrayList<CSSRuleDeclaration>()
    override val cssRules: CSSRuleDeclarationList get() = rules

    init {
        document.head!!.append(style)
    }

    override fun add(cssRule: CSSRuleDeclaration) {
        rules.add(cssRule)

        (style.sheet as? CSSStyleSheet)?.let { cssStylesheet ->
            clearCSSRules(cssStylesheet)
            setCSSRules(cssStylesheet, cssRules)
        }
    }
}
