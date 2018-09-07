package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator

class RotateRocketAnimationActivity : BaseAnimationActivity() {
    override fun onStartAnimation() {
        val valueAnimation = ValueAnimator.ofFloat(0f, 360f)

        valueAnimation.addUpdateListener {
            val value = it.animatedValue as Float
            rocket.rotation = value
        }

        valueAnimation.interpolator = LinearInterpolator()
        valueAnimation.duration = BaseAnimationActivity.DEFAULT_ANIMATION_DURATION

        valueAnimation.start()
    }
}
