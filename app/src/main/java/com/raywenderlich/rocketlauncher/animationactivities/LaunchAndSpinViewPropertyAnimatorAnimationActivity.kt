package com.raywenderlich.rocketlauncher.animationactivities

class LaunchAndSpinViewPropertyAnimatorAnimationActivity : BaseAnimationActivity() {
//    ViewPropertyAnimator may provide better performance for multiple simultaneous animations
    override fun onStartAnimation() {
        rocket.animate()
                .translationY(-screenHeight)
                .rotation(720f)
                .setDuration(BaseAnimationActivity.DEFAULT_ANIMATION_DURATION)
                .start()
    }
}
