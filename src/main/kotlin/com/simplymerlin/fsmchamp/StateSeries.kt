package com.simplymerlin.fsmchamp

open class StateSeries(states: List<State> = emptyList()) : StateHolder(states) {

    override var time: Int
        get() = if (ended) 0 else states.filter { !it.ended }.sumOf { it.time }
        set(_) {}


    protected var current = 0
    protected var skipping: Boolean = false

    constructor(vararg states: State) : this(states.toList())

    fun addNext(state: State) {
        states.add(current + 1, state)
    }

    fun addNext(newStates: List<State>) {
        var i = 1
        newStates.forEach { state ->
            states.add(current + i, state)
            ++i
        }
    }

    fun skip() {
        skipping = true
    }

    override fun onStart() {
        if(states.isEmpty()) {
            end()
            return
        }

        states[current].start()
    }

    override fun onUpdate() {
        if((states[current].isReadyToEnd() && !states[current].frozen) || skipping) {
            if(skipping)
                skipping = false

            states[current].end()
            ++current

            if(current >= states.size) {
                end()
                return
            }

            states[current].start()
        }
        states[current].update()
    }

    override fun isReadyToEnd(): Boolean {
        return ended || (current == states.size - 1 && states[current].isReadyToEnd())
    }

    override fun onEnd() {
        if(current < states.size)
            states[current].end()
    }
}
