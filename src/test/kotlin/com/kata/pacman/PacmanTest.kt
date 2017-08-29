package com.kata.pacman

import com.kata.pacman.Direction.*
import org.junit.Assert.assertEquals
import org.junit.Test

class PacmanTest {

    @Test
    fun `moving to the right changes the position of the pacman`() {
        movePacman(at(0, 0), facing(RIGHT), endsUp(at(1,0)))
    }

    @Test
    fun `facing to the left changes the position of the pacman`() {
        movePacman(at(1, 0), facing(LEFT), endsUp(at(0,0)))
    }

    @Test
    fun `facing up changes the position of the pacman`() {
        movePacman(at(0, 0), facing(UP), endsUp(at(0,1)))
    }

    @Test
    fun `facing down changes the position of the pacman`() {
        movePacman(at(0, 0), facing(DOWN), endsUp(at(0,-1)))
    }

    private fun endsUp(value: Position): Position = value

    private fun facing(value: Direction): Direction = value

    private fun  at(x: Int, y: Int): Position = Position(x,y)

    private fun movePacman(at: Position, facing: Direction, endsUpAt: Position) {
        val pacman = Pacman(at, facing)

        pacman.move()

        assertEquals(pacman.position(), endsUpAt)
    }
}


