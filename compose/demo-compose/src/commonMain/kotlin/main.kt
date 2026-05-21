import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DeveloperBoard
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import kotlinx.coroutines.launch
import net.kodein.theme.compose.KodeinMaterial


enum class Page(
    val title: String,
    val icon: ImageVector,
    val content: @Composable (isDark: Boolean) -> Unit,
) {
    Colors("Colors", Icons.Default.ColorLens, { Colors(isDark = it) }),
    Components("Components", Icons.Default.DeveloperBoard, { Components() }),
}

@OptIn(ExperimentalGridApi::class, ExperimentalMaterial3ExpressiveApi::class)
fun main() = singleWindowApplication(
    title = "Kodein Material Theme",
    state = WindowState(width = 1200.dp, height = 760.dp),
) {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    var isKodein by remember { mutableStateOf(true) }
    var isDark by remember { mutableStateOf(isSystemInDarkTheme) }
    var page by remember { mutableStateOf(Page.Colors) }

    MaterialTheme(
        colorScheme =
            if (isKodein) { if (isDark) KodeinMaterial.darkColorScheme else KodeinMaterial.lightColorScheme }
            else { if (isDark) darkColorScheme() else lightColorScheme() },
        typography = if (isKodein) KodeinMaterial.typography else Typography(),
        shapes = if (isKodein) KodeinMaterial.shapes else Shapes(),
    ) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Text("Theme Demo", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(16.dp))
                    HorizontalDivider()
                    Page.entries.forEach { p ->
                        NavigationDrawerItem(
                            label = { Text(text = p.title) },
                            icon = { Icon(p.icon, contentDescription = p.title) },
                            selected = page == p,
                            onClick = { page = p ; scope.launch { drawerState.close() } }
                        )
                    }
                }
            },
            gesturesEnabled = drawerState.isOpen,
            drawerState = drawerState,
        ) {
            val hostState = remember { SnackbarHostState() }
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("${if (isKodein) "Kodein" else "Default"} ${if (isDark) "Dark" else "Light"} ${page.title}") },
                        navigationIcon = {
                            IconButton(
                                onClick = { scope.launch { drawerState.open() } },
                            ) {
                                Icon(Icons.Default.Menu, contentDescription = "Open menu")
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = { isKodein = !isKodein },
                            ) {
                                Text(if (isKodein) "D" else "K", fontWeight = FontWeight.Black, fontSize = 1.2.em)
                            }
                            IconButton(
                                onClick = { isDark = !isDark },
                            ) {
                                Icon(if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode, contentDescription = "Toggle Theme")
                            }
                        }
                    )
                },
                floatingActionButton = {
                    if (page == Page.Components) {
                        ExtendedFloatingActionButton(
                            onClick = {
                                scope.launch {
                                    hostState.showSnackbar(
                                        message = "This is a snack bar!",
                                        actionLabel = "Action",
                                        withDismissAction = true,
                                    )
                                }
                            },
                            text = { Text("Show Snackbar") },
                            icon = { Icon(Icons.Default.Add, "Add") },
                        )
                    }
                },
                snackbarHost = {
                    SnackbarHost(
                        hostState = hostState,
                    )
                },
                modifier = Modifier.fillMaxSize()
            ) { paddingValues ->
                Box(Modifier.padding(paddingValues)) {
                    val scrollState = rememberScrollState()
                    Box(
                        contentAlignment = Alignment.TopCenter,
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                    ) {
                        page.content(isDark)
                    }
                    VerticalScrollbar(
                        adapter = rememberScrollbarAdapter(scrollState),
                        style = defaultScrollbarStyle().copy(
                            unhoverColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                            hoverColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                        ),
                        modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                    )
                }
            }
        }
    }
}

