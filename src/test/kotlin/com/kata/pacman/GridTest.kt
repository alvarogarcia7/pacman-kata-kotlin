package com.kata.pacman

import org.junit.Assert.assertEquals
import org.junit.Test

class GridTest {

    @Test
    fun `moving to the right changes the position of the pacman`() {
        val pacman = Pacman(Position(0,0), Direction.RIGHT)
        val grid = Grid(Dimension(2,1),  pacman)

        pacman.moveRight()

        assertEquals(pacman.position(), Position(1,0))
    }
}

enum class Direction {
    RIGHT
}

data class Position(var x: Int, var y: Int)

class Grid(dimension: Dimension, pacman: Pacman) {

}

class Dimension(x: Int, y: Int) {

}

class Pacman {
    private var position: Position

    constructor(position: Position, direction: Direction) {
        this.position = position
    }

    fun moveRight() {
        position.x++
    }

    fun position(): Position {
        return position
    }

}

