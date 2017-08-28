package com.kata.pacman

import org.junit.Assert.*
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

class Position(x: Int, y: Int) {

}

class Grid(dimension: Dimension, pacman: Pacman) {

}

class Dimension(x: Int, y: Int) {

}

class Pacman {
    constructor(position: Position,  direction: Direction)

    fun moveRight() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun position(): Position {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

