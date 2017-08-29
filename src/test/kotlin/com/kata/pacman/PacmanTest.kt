package com.kata.pacman

import com.kata.pacman.Direction.*
import org.junit.Assert.assertEquals
import org.junit.Test

class PacmanTest {

    // function as an alias. Taken from https://opencredo.com/the-destructor-pattern/
    private val at = ::Position

    private val any_position: Position = at(0,0)

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

    @Test
    fun `turning to any direction changes the direction of the pacman`() {
        setNewPacmanDirection(any_position, newDirection(LEFT), endsUp(facing(LEFT)))
    }

    private fun  newDirection(value: Direction): Direction = value

    private fun movePacman(at: Position, facing: Direction, endsUpAt: Position) {
        val pacman = Pacman(at, facing)

        pacman.move()

        assertEquals(pacman.position(), endsUpAt)
    }

    private fun setNewPacmanDirection(at: Position, originalDirection: Direction, newDirection: Direction) {
        val pacman = Pacman(at, originalDirection)

        pacman.face(newDirection)

        assertEquals(pacman.facing(), newDirection)
    }

    private fun <T> endsUp(value: T): T = value

    private fun facing(value: Direction): Direction = value

}


