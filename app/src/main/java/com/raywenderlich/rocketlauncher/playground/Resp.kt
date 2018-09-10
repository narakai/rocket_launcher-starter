package com.raywenderlich.rocketlauncher.playground

class Resp<T> {
    var code: Int = 0
    var body: T? = null
    var errorMessage: String? = null

    fun isSuccess(): Boolean = code == 200

    override fun toString(): String {
        return "Resp(code=$code, body=$body, errorMessage=$errorMessage)"
    }
}