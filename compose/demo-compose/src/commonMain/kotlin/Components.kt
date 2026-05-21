import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Looks3
import androidx.compose.material.icons.filled.Looks4
import androidx.compose.material.icons.filled.LooksOne
import androidx.compose.material.icons.filled.LooksTwo
import androidx.compose.material.icons.filled.Mode
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberSliderState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp


@Composable
fun Components() {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(32.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            OutlinedCard(Modifier.width(320.dp)) { DemoCardContent("Outlined") }
            Card(Modifier.width(320.dp)) { DemoCardContent("Regular") }
            ElevatedCard(Modifier.width(320.dp)) { DemoCardContent("Elevated") }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.height(IntrinsicSize.Max),
        ) {
            OutlinedCard(
                modifier = Modifier.fillMaxHeight().width(320.dp)
            ) {
                DemoFormContent(
                    type = "Default",
                    comp = FormComponents.Default,
                )
            }
            OutlinedCard(
                modifier = Modifier.fillMaxHeight().width(320.dp)
            ) {
                DemoFormContent(
                    type = "Outlined",
                    comp = FormComponents.Outlined,
                )
            }
        }

        OutlinedCard {
            ChipsContent()
        }

        OutlinedCard(
            modifier = Modifier.width(512.dp)
        ) {
            otherContent()
        }
    }
}

@Composable
private fun DemoCardContent(
    type: String,
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TooltipBox(
                positionProvider = TooltipDefaults.rememberTooltipPositionProvider(TooltipAnchorPosition.Above),
                tooltip = {
                    PlainTooltip {
                        Text("Tooltip")
                    }
                },
                state = rememberTooltipState()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.inversePrimary, CircleShape)
                        .size(32.dp)
                ) {
                    Row {
                        Text(type[0].toString(), style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onPrimaryContainer)
                    }
                }
            }
            Spacer(Modifier.weight(1f))
            Box {
                var menuExpanded by remember { mutableStateOf(false) }
                IconButton(onClick = { menuExpanded = true }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "Favorite")
                }
                DropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false },
                ) {
                    DropdownMenuItem(
                        text = { Text("Edit") },
                        leadingIcon = { Icon(Icons.Default.Edit, "Edit") },
                        onClick = { menuExpanded = false }
                    )
                    DropdownMenuItem(
                        text = { Text("Delete") },
                        leadingIcon = { Icon(Icons.Default.Delete, "Delte") },
                        onClick = { menuExpanded = false }
                    )
                }
            }
        }
        Column(Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("$type Card", style = MaterialTheme.typography.headlineSmall)
                Badge(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.padding(start = 8.dp),
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        modifier = Modifier.size(8.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text("Favorite")
                }
            }
            Text("And it is has a subtitle", style = MaterialTheme.typography.labelLarge)
            Spacer(Modifier.height(16.dp))
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras dictum tellus tincidunt massa accumsan scelerisque. Integer suscipit dignissim leo ac tristique.")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private interface FormComponents {
    @Composable fun TextField(
        state: TextFieldState,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        label: @Composable (TextFieldLabelScope.() -> Unit)? = null,
        edmbExpanded: Boolean? = null,
    )

    @Composable
    fun Button(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        content: @Composable RowScope.() -> Unit,
    )

    object Default : FormComponents {
        @Composable
        override fun TextField(
            state: TextFieldState,
            modifier: Modifier,
            enabled: Boolean,
            label: @Composable (TextFieldLabelScope.() -> Unit)?,
            edmbExpanded: Boolean?,
        ) {
            androidx.compose.material3.TextField(
                state = state,
                modifier = modifier,
                enabled = enabled,
                readOnly = if (edmbExpanded != null) true else false,
                label = label,
                trailingIcon =
                    if (edmbExpanded != null) ({ ExposedDropdownMenuDefaults.TrailingIcon(expanded = edmbExpanded) })
                    else null,
                colors =
                    if (edmbExpanded != null) ExposedDropdownMenuDefaults.textFieldColors()
                    else TextFieldDefaults.colors()
            )
        }
        @Composable
        override fun Button(
            onClick: () -> Unit,
            modifier: Modifier,
            enabled: Boolean,
            content: @Composable RowScope.() -> Unit,
        ) {
            androidx.compose.material3.Button(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled,
                content = content,
            )
        }
    }

    object Outlined : FormComponents {
        @Composable
        override fun TextField(
            state: TextFieldState,
            modifier: Modifier,
            enabled: Boolean,
            label: @Composable (TextFieldLabelScope.() -> Unit)?,
            edmbExpanded: Boolean?,
        ) {
            androidx.compose.material3.OutlinedTextField(
                state = state,
                modifier = modifier,
                enabled = enabled,
                readOnly = if (edmbExpanded != null) true else false,
                label = label,
                trailingIcon =
                    if (edmbExpanded != null) ({ ExposedDropdownMenuDefaults.TrailingIcon(expanded = edmbExpanded) })
                    else null,
                colors =
                    if (edmbExpanded != null) ExposedDropdownMenuDefaults.outlinedTextFieldColors()
                    else OutlinedTextFieldDefaults.colors()
            )
        }
        @Composable
        override fun Button(
            onClick: () -> Unit,
            modifier: Modifier,
            enabled: Boolean,
            content: @Composable RowScope.() -> Unit,
        ) {
            androidx.compose.material3.OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled,
                content = content,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DemoFormContent(
    type: String,
    comp: FormComponents,
) {
    Text(
        text = type,
        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier.padding(top = 4.dp, start = 16.dp)
    )

    var enabled by remember { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = enabled,
            onCheckedChange = { enabled = it },
        )
        Text("Enabled")
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        val state = rememberTextFieldState("")
        comp.TextField(
            state = state,
            enabled = enabled,
            label = { Text("Text Field") },
            modifier = Modifier.fillMaxWidth()
        )
        var expanded by remember { mutableStateOf(false) }
        val selected = rememberTextFieldState("Option One")
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = if (enabled) !expanded else false },
            modifier = Modifier.fillMaxWidth()
        ) {
            comp.TextField(
                state = selected,
                enabled = enabled,
                label = { Text("Exposed Dropdown Menu Box", Modifier.alpha(if (enabled) 1f else 0.38f)) },
                edmbExpanded = expanded,
                modifier = Modifier
                    .fillMaxWidth()
                    .pointerHoverIcon(PointerIcon.Default, true)
                    .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem(
                    text = { Text("Option One") },
                    onClick = { selected.setTextAndPlaceCursorAtEnd("Option One") ; expanded = false },
                )
                DropdownMenuItem(
                    text = { Text("Option Two") },
                    onClick = { selected.setTextAndPlaceCursorAtEnd("Option Two") ; expanded = false },
                )
                DropdownMenuItem(
                    text = { Text("Option Three") },
                    onClick = { selected.setTextAndPlaceCursorAtEnd("Option Three") ; expanded = false },
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            var checked by remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                enabled = enabled,
            )
            Text("Check box", Modifier.alpha(if (enabled) 1f else 0.38f))
            Spacer(Modifier.weight(1f))
            Switch(
                checked = checked,
                onCheckedChange = { checked = it },
                enabled = enabled,
            )
            Text("Switch", Modifier.padding(start = 16.dp).alpha(if (enabled) 1f else 0.38f))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            var selected by remember { mutableStateOf(1) }
            RadioButton(
                selected = selected == 1,
                onClick = { selected = 1 },
                enabled = enabled,
            )
            Text("One", Modifier.alpha(if (enabled) 1f else 0.38f))
            RadioButton(
                selected = selected == 2,
                onClick = { selected = 2 },
                enabled = enabled,
            )
            Text("Two", Modifier.alpha(if (enabled) 1f else 0.38f))
            RadioButton(
                selected = selected == 3,
                onClick = { selected = 3 },
                enabled = enabled,
            )
            Text("Three", Modifier.alpha(if (enabled) 1f else 0.38f))
        }
        Spacer(Modifier.weight(1f))
        comp.Button(
            onClick = {},
            enabled = enabled,
            modifier = Modifier.align(Alignment.End)
        ) { Text("Submit") }
    }
}

@Composable
fun ChipsContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        var enabled by remember { mutableStateOf(true) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = enabled,
                onCheckedChange = { enabled = it },
            )
            Text("Enabled")
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AssistChip(
                onClick = {},
                label = { Text("Assist Chip") },
                leadingIcon = { Icon(Icons.Filled.Info, "Info") },
                enabled = enabled,
            )
            var inputSelected by remember { mutableStateOf(false) }
            InputChip(
                selected = inputSelected,
                onClick = { inputSelected = !inputSelected },
                label = { Text("Input Chip") },
                leadingIcon = { Icon(Icons.Filled.Mode, "Mode") },
                enabled = enabled,
            )
            var filterSelected by remember { mutableStateOf(false) }
            FilterChip(
                selected = filterSelected,
                onClick = { filterSelected = !filterSelected },
                label = { Text("Filter Chip") },
                leadingIcon = { Icon(if (filterSelected) Icons.Filled.Check else Icons.Filled.Star, "Star") },
                enabled = enabled,
            )
            SuggestionChip(
                onClick = {},
                label = { Text("Suggestion Chip") },
                icon = { Icon(Icons.Filled.Info, "Info") },
                enabled = enabled,
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ElevatedAssistChip(
                onClick = {},
                label = { Text("Assist Chip") },
                leadingIcon = { Icon(Icons.Filled.Info, "Info") },
                enabled = enabled,
            )
            var filterSelected by remember { mutableStateOf(false) }
            ElevatedFilterChip(
                selected = filterSelected,
                onClick = { filterSelected = !filterSelected },
                label = { Text("Filter Chip") },
                leadingIcon = { Icon(if (filterSelected) Icons.Filled.Check else Icons.Filled.Star, "Star") },
                enabled = enabled,
            )
            ElevatedSuggestionChip(
                onClick = {},
                label = { Text("Suggestion Chip") },
                icon = { Icon(Icons.Filled.Info, "Info") },
                enabled = enabled,
            )
        }
    }
}

@Composable
fun otherContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        val state = rememberSliderState(0.5f)
        Slider(
            state = state,
        )
        LinearProgressIndicator(
            progress = { state.value },
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
            CircularProgressIndicator(
                progress = { state.value },
            )
            CircularProgressIndicator()
        }

        var selected by remember { mutableStateOf(0) }

        @Composable
        fun TabRowContent() {
            Tab(
                selected = selected == 0,
                onClick = { selected = 0 },
                text = { Text("Tab One") },
                icon = { Icon(Icons.Filled.LooksOne, "One") },
            )
            Tab(
                selected = selected == 1,
                onClick = { selected = 1 },
                text = { Text("Tab two") },
                icon = { Icon(Icons.Filled.LooksTwo, "Two") },
            )
            Tab(
                selected = selected == 2,
                onClick = { selected = 2 },
                text = { Text("Tab three") },
                icon = { Icon(Icons.Filled.Looks3, "Three") },
            )
            Tab(
                selected = selected == 3,
                onClick = { selected = 3 },
                text = { Text("Tab four") },
                icon = { Icon(Icons.Filled.Looks4, "Four") },
            )
        }

        PrimaryTabRow(
            selectedTabIndex = selected,
        ) {
            TabRowContent()
        }
        SecondaryTabRow(
            selectedTabIndex = selected,
        ) {
            TabRowContent()
        }
    }
}