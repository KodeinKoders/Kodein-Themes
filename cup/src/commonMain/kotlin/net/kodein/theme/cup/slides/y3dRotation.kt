package net.kodein.theme.cup.slides

import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import net.kodein.cup.TransitionSet


@OptIn(ExperimentalAnimationApi::class)
public val TransitionSet.Companion.y3dRotation: TransitionSet get() {
    val y3dRSpec = tween<Float>(2_000)
    return TransitionSet(
        enter = { fadeIn(y3dRSpec) },
        exit = { fadeOut(y3dRSpec) },
        modifier = { type ->
            val dir = when (LocalLayoutDirection.current) {
                LayoutDirection.Ltr -> 1
                LayoutDirection.Rtl -> -1
            }

            val rotation by transition.animateFloat(
                transitionSpec = { y3dRSpec }
            ) {
                when (it) {
                    EnterExitState.PreEnter -> if (type.isForward) (180f * dir) else (-180f * dir)
                    EnterExitState.PostExit -> if (type.isForward) (-180f * dir) else (180f * dir)
                    EnterExitState.Visible -> 0f
                }
            }

            Modifier
                .graphicsLayer(
                    rotationY = rotation,
                    cameraDistance = 28f
                )
        }
    )
}
