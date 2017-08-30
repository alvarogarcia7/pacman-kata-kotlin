package com.kata.pacman

import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class PacmanOnAGridTest {

    // function as an alias. Taken from https://opencredo.com/the-destructor-pattern/
    private val at = ::Position

    @Test
    fun `wrap the position - from rightmost to leftmost`() {
        movePacman(at(1, 0), facing(Direction.RIGHT), endsUp(at(0,0)))
    }

    @Test
    fun `wrap the position - from rightmost to leftmost, when past the border`() {
        movePacman(at(2, 0), facing(Direction.RIGHT), endsUp(at(2+1-2,0)))
    }

    @Test
    fun `wrap the position - from leftmost to rightmost`() {
        movePacman(at(0, 0), facing(Direction.LEFT), endsUp(at(1,0)))
    }

    @Test
    fun `wrap the position - from leftmost to rightmost, when past the border`() {
        movePacman(at(-1, 0), facing(Direction.LEFT), endsUp(at(-1-1+2 /*moves to the left, then wraps*/,0)))
    }

    @Test
    @Ignore
    fun `wrap the position - from topmost to bottommost`() {
        movePacman(at(0, 0), facing(Direction.UP), endsUp(at(0,1)))
    }

    @Test
    @Ignore
    fun `wrap the position - from bottommost to topmost`() {
        movePacman(at(0, 1), facing(Direction.DOWN), endsUp(at(0,0)))
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


