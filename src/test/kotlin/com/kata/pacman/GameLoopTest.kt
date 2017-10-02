package com.kata.pacman

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

    @Test
    fun `prints the game representation at every loop`() {
        val ui = MockUI()
        val runner = Runner(ui)

        runner.loop()

        assertEquals(ui.called("print"), 1)
    }

}

class MockUI : UI {
    private val called: MutableMap<String, Int> = hashMapOf()

    override fun print() {
        increase("print")
    }

    override fun clean() {
        increase("clean")
    }

    fun called(fnName: String): Int {
        return this.called.getOrDefault(fnName, 0)
    }

    private fun increase(methodName: String) {
        this.called.set(methodName, this.called.getOrDefault(methodName, 0) + 1)
    }

}

