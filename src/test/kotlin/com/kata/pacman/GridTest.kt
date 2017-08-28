package com.kata.pacman

import org.junit.Assert.assertEquals
import org.junit.Test

class GridTest {

    @Test
    fun `moving to the right changes the position of the pacman`() {
        val pacman = Pacman(Position(0,0), Direction.RIGHT)

        pacman.move()

        assertEquals(pacman.position(), Position(1,0))
    }

    @Test
    fun `facing to the left changes the position of the pacman`() {
        val pacman = Pacman(Position(1,0), Direction.LEFT)

        pacman.move()

        assertEquals(pacman.position(), Position(0,0))
    }
}

enum class Direction {
    LEFT {
        override fun move(): Position {
            return Position(-1,0)
        }
    },

    RIGHT {
        override fun move(): Position {
            return Position(1,0)
        }
    };

    abstract fun move() : Position
}

data class Position(var x: Int, var y: Int) {
    fun add(move: Position) {
        this.x += move.x
        this.y += move.y
    }
}

class Grid(dimension: Dimension, pacman: Pacman) {

}

class Dimension(x: Int, y: Int) {

}

class Pacman {
    private var position: Position
    private var direction: Direction

    constructor(position: Position, direction: Direction) {
        this.position = position
        this.direction = direction
    }

    fun move() {
        position.add(direction.move())
    }

    fun position(): Position {
        return position
    }

}

