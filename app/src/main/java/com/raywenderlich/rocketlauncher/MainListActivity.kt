package com.raywenderlich.rocketlauncher

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.raywenderlich.rocketlauncher.animationactivities.*
import com.raywenderlich.rocketlauncher.playground.Resp
import com.raywenderlich.rocketlauncher.playground.User
import kotlinx.android.synthetic.main.activity_main_layout.*
import java.util.*

class MainListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)

        operator()
        operator2()

        recycler_view.layoutManager = LinearLayoutManager(this)

        val items = ArrayList<RocketAnimationItem>()

        items.add(RocketAnimationItem(getString(R.string.title_no_animation),
                Intent(this, NoAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_launch_rocket),
                Intent(this, LaunchRocketValueAnimatorAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_spin_rocket),
                Intent(this, RotateRocketAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_accelerate_rocket),
                Intent(this, AccelerateRocketAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_launch_rocket_objectanimator),
                Intent(this, LaunchRocketObjectAnimatorAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_color_animation),
                Intent(this, ColorAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.launch_spin),
                Intent(this, LaunchAndSpinAnimatorSetAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.launch_spin_viewpropertyanimator),
                Intent(this, LaunchAndSpinViewPropertyAnimatorAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_with_doge),
                Intent(this, FlyWithDogeAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_animation_events),
                Intent(this, WithListenerAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_there_and_back),
                Intent(this, FlyThereAndBackAnimationActivity::class.java)))

        items.add(RocketAnimationItem(getString(R.string.title_jump_and_blink),
                Intent(this, XmlAnimationActivity::class.java)))

        recycler_view.adapter = RocketAdapter(this, items)
    }

    private fun operator2() {
        var resp: Resp<String>? = Resp()

        if (resp != null) {
            if (resp.isSuccess()) {
                // do success
                println(resp.body)
            } else {
                // do fail
                println(resp.errorMessage)
            }
        }

        resp?.run {
            if (isSuccess()) {
                // do success
                println(resp.body)
            } else {
                println(resp.errorMessage)
            }
        }

        resp?.apply {
            if (isSuccess()) {
                // do success
                println(resp.body)
            } else {
                println(resp.errorMessage)
            }
        }

        resp?.let {
            if (it.isSuccess()) {
                // do success
                println(it.body)
            } else {
                println(it.errorMessage)
            }
        }

        resp?.also {
            if (it.isSuccess()) {
                // do success
                println(it.body)
            } else {
                println(it.errorMessage)
            }
        }

    }

    private fun operator() {
        var user = User()
        user.id = 1
        user.name = "test1"
        user.hobbies = listOf("aa", "bb", "cc")
        println("user = $user")

//      如果使用let,apply,run,with可以这样，let和also是需要it的，其他的默认使用this。
        user.let {
            it.id = 2
            it.name = "test2"
            it.hobbies = listOf("aa", "bb", "cc")
        }
        println("user = $user")

        user.also {
            it.id = 3
            it.name = "test3"
            it.hobbies = listOf("aa", "bb", "cc")
        }
        println("user = $user")

        user.apply {
            id = 2
            name = "test2"
            hobbies = listOf("aa", "bb", "cc")
            Date()
        }
        println("user = $user")

        user.run {
            id = 3
            name = "test3"
            hobbies = listOf("aa", "bb", "cc")
            Date()
        }
        println("user = $user")

        with(user) {
            id = 4
            name = "test4"
            hobbies = listOf("aa", "bb", "cc")
            Date()
        }
        println("user = $user")

    }
}
