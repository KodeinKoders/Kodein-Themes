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
import androidx.compose.ui.unit.LayoutDirection
import net.kodein.cup.TransitionSet


@OptIn(ExperimentalAnimationApi::class)
public fun TransitionSet.Companion.y3dRotation(layoutDirection: LayoutDirection): TransitionSet {
    val y3dRSpec = tween<Float>(2_000)
    return TransitionSet(
        enterForward = fadeIn(y3dRSpec),
        enterBackward = fadeIn(y3dRSpec),
        exitForward = fadeOut(y3dRSpec),
        exitBackward = fadeOut(y3dRSpec),
        modifier = { type ->
            val dir = when (layoutDirection) {
                LayoutDirection.Ltr -> 1
                LayoutDirection.Rtl -> -1
            }

            val rotation by transition.animateFloat(
                transitionSpec = { y3dRSpec }
            ) {
                val max = when (type) {
                    TransitionSet.Type.EnterForward -> 180f * dir
                    TransitionSet.Type.EnterBackward -> -180f * dir
                    TransitionSet.Type.ExitForward -> -180f * dir
                    TransitionSet.Type.ExitBackward -> 180f * dir
                }
                when (it) {
                    EnterExitState.PreEnter -> max
                    EnterExitState.PostExit -> max
                    EnterExitState.Visible -> 0f
                }
            }

            Modifier
                .graphicsLayer {
                    rotationY = rotation
                }
        }
    )
}
