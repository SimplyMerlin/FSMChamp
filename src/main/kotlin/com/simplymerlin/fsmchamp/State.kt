package com.simplymerlin.fsmchamp

abstract class State {

    abstract var time: Int

    var started: Boolean = false
        private set

    private var updating = false

    var ended: Boolean = false
        private set

    open var frozen: Boolean = false

    open fun start() {
        if (started || ended)
            return
        started = true
        try {
            onStart()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    abstract fun onStart()

    open fun update() {
        if(!started || ended || updating)
            return
        updating = true
        if(isReadyToEnd() && !frozen) {
            end()
            return
        }

        --time

        try {
            onUpdate()
        } catch (e: Throwable) {
            e.printStackTrace()
        }

        updating = false
    }

    abstract fun onUpdate()

    open fun end() {
        if(!started || ended)
            return
        ended = true
        time = 0
        try {
            onEnd()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    open fun isReadyToEnd() : Boolean {
        return ended || time <= 0
    }

    abstract fun onEnd()

}