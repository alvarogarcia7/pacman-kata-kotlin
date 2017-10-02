package com.kata.pacman

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class GameLoopTest {

    @Test
    fun `cleans the screen at every loop`() {
        val ui = MockUI()
        val runner = Runner(ui)

        runner.loop()

        assertEquals(ui.called("clean"), 1)
    }

}

class MockUI : UI {
    private val called: MutableMap<String, Int> = hashMapOf()

    override fun clean() {
        this.called.set("clean", this.called.getOrDefault("clean", 0)+1)
    }

    fun called(fnName: String): Int {
        return this.called.getOrDefault(fnName, 0)
    }

}

class Runner(val ui: UI) {
    fun loop() {
        ui.clean()
    }

}

interface UI {
    fun clean()
}
