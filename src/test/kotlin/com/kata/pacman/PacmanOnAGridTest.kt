package com.kata.pacman

import org.junit.Assert
import org.junit.Test

class PacmanOnAGridTest {

    // function as an alias. Taken from https://opencredo.com/the-destructor-pattern/
    private val at = ::Position

    @Test
    fun `wrap the position - from rightmost to leftmost`() {
        movePacman(at(1, 0), facing(Direction.RIGHT), endsUp(at(0,0)))
    }

    private fun movePacman(at: Position, facing: Direction, endsUpAt: Position) {
        var grid = Grid(Dimension(2, 2))
        val pacman = Pacman(at, facing, grid)

        pacman.move()

        Assert.assertEquals(pacman.position(), endsUpAt)
    }

    private fun <T> endsUp(value: T): T = value

    private fun facing(value: Direction): Direction = value

}


