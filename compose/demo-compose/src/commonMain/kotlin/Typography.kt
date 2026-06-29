import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp


enum class Lines(val color: (@Composable () -> Color)?) {
    One(null),
    TwoSame({ LocalContentColor.current }),
    TwoPrimary({ MaterialTheme.colorScheme.primary }),
}
@Composable
fun Typography() {

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        var lines by remember { mutableStateOf(Lines.One) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = lines == Lines.One,
                onClick = { lines = Lines.One }
            )
            Text("One line")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = lines == Lines.TwoSame,
                onClick = { lines = Lines.TwoSame }
            )
            Text("Two lines (same color)")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = lines == Lines.TwoPrimary,
                onClick = { lines = Lines.TwoPrimary }
            )
            Text("Two lines (second is primary)")
        }

        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        val typography = MaterialTheme.typography
        listOf(
            "displayLarge",
            "displayMedium",
            "displaySmall",
            "headlineLarge",
            "headlineMedium",
            "headlineSmall",
            "titleLarge",
            "titleMedium",
            "titleSmall",
            "bodyLarge",
            "bodyMedium",
            "bodySmall",
            "labelLarge",
            "labelMedium",
            "labelSmall",
        ).forEach { name ->
            val styleNormal = remember(typography, name) {
                typography::class.java.getMethod("get" + name.replaceFirstChar { it.uppercase() }).invoke(typography) as TextStyle
            }
            val styleEmphasized = remember(typography, name) {
                typography::class.java.getMethod("get" + name.replaceFirstChar { it.uppercase() } + "Emphasized").invoke(typography) as TextStyle
            }
            val nameText = name.split(Regex("(?<!^)(?=[A-Z])")).joinToString(" ") { it.lowercase() }
            Row {
                listOf(styleNormal, styleEmphasized).forEach { style ->
                    Text(
                        text = buildAnnotatedString {
                            append(nameText.replaceFirstChar { it.uppercase() })
                            val secondLineColor = lines.color?.invoke()
                            if (secondLineColor != null) {
                                appendLine()
                                withStyle(SpanStyle(color = secondLineColor)) {
                                    append(nameText.reversed())
                                }
                            }
                        },
                        style = style,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            HorizontalDivider(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }

        SelectionContainer {
            Column {
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("Lorem ipsum ") }
                        append(" ")
                        withStyle(SpanStyle(fontStyle = FontStyle.Italic)) { append("dolor sit amet") }
                        append(", consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris. Nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit. Esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. Sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem. Accusantium doloremque laudantium, totam rem aperiam.")
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = "Eaque ipsa quae ab illo inventore veritatis et quasi architecto. Beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit. Sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet. Consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt. Ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam. Nisi ut aliquid ex ea commodi consequatur. Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse.",
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = "Quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat. Quo voluptas nulla pariatur. At vero eos et accusamus et iusto odio dignissimos ducimus. Qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores. Et quas molestias excepturi sint occaecati cupiditate non provident. Similique sunt in culpa qui officia deserunt mollitia animi. Id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit. Quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est.",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }

}
