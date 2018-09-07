package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ObjectAnimator

class LaunchRocketObjectAnimatorAnimationActivity : BaseAnimationActivity() {
//  ObjectAnimator, a subclass of ValueAnimator. If you only need to animate a single property of a single object,
//    ObjectAnimator may just be your new best friend.

    override fun onStartAnimation() {
        val objectAnimator = ObjectAnimator.ofFloat(rocket, "translationY", 0f, -screenHeight)
        objectAnimator.duration = BaseAnimationActivity.Companion.DEFAULT_ANIMATION_DURATION
        objectAnimator.start()
    }
}


//Here’s what you’re doing:
//Creating an instance of ObjectAnimator (like you did with ValueAnimator) except that the former takes two more parameters:
//rocket is the object to animate
//The object must have a property corresponding to the name of the property you wish to change, which in this example is “translationY”. You’re able to do this because rocket is an object of class View, which, in its base Java class, has an accessible setter with setTranslationY().
//You set the duration for the animation and start it.

//There’s a limitation to ObjectAnimator — it can’t animate two objects simultaneously. To work around it, you create two instances of ObjectAnimator.