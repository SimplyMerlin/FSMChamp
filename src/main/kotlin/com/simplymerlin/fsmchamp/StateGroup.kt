package com.simplymerlin.fsmchamp

open class StateGroup(states: List<State> = emptyList()) : StateHolder(states) {

    override fun onStart() {
        states.forEach(State::start)
    }

    override fun onUpdate() {
        states.forEach(State::update)
        if(states.all { it.ended })
            end()
    }

    override fun onEnd() {
        states.forEach(State::end)
    }

    override fun isReadyToEnd() = states.all(State::isReadyToEnd)

    override var time: Int = 0
        get() = states.maxBy { it.time }.time
}