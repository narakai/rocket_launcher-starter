package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ValueAnimator
import android.view.animation.AccelerateInterpolator

class AccelerateRocketAnimationActivity : BaseAnimationActivity() {
    override fun onStartAnimation() {
        val valueAnimation = ValueAnimator.ofFloat(0f, -screenHeight)

        valueAnimation.addUpdateListener {
            val value = it.animatedValue as Float
            rocket.translationY = value
        }

        valueAnimation.interpolator = AccelerateInterpolator(1.5f)
        valueAnimation.duration = BaseAnimationActivity.DEFAULT_ANIMATION_DURATION

        valueAnimation.start()
    }
}
