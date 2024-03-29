package net.kodein.theme.cup.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.KodeinVectorImages
import net.kodein.theme.compose.img.KodeinMonogram
import net.kodein.theme.cup.kStyled

@Composable
public fun KodeinLogo(
    division: String,
    color: Color = Color(KodeinColors.orange),
    subtext: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberVectorPainter(KodeinVectorImages.Logo.KodeinMonogram),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color),
            modifier = Modifier.height(112.dp).padding(end = 12.dp)
        )
        Column {
            Text(
                text = kStyled { "KODEIN${+l}$division${-l}" },
                color = color,
                fontWeight = FontWeight.Bold,
                fontSize = 56.sp,
                lineHeight = 56.sp,
                modifier = Modifier
                    .height(46.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 2.dp)
            ) {
                ProvideTextStyle(
                    TextStyle(
                        color = color,
                        fontSize = 22.sp
                    )
                ) {
                    Text("painless ")
                    subtext()
                }
            }
        }
    }
}