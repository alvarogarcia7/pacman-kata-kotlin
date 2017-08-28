package com.kata.pacman

import com.kata.pacman.Direction.*
import org.junit.Assert.assertEquals
import org.junit.Test

class GridTest {

    @Test
    fun `moving to the right changes the position of the pacman`() {
        movePacman(at(0, 0), facing(RIGHT), endsUp(at(1,0)))
    }

    @Test
    fun `facing to the left changes the position of the pacman`() {
        val pacman = Pacman(Position(1,0), LEFT)

        pacman.move()

        assertEquals(pacman.position(), Position(0,0))
    }

    @Test
    fun `facing up changes the position of the pacman`() {
        val pacman = Pacman(Position(0,0), UP)

        pacman.move()

        assertEquals(pacman.position(), Position(0,1))
    }

    @Test
    fun `facing down changes the position of the pacman`() {
        val pacman = Pacman(Position(0,0), DOWN)

        pacman.move()

        assertEquals(pacman.position(), Position(0,-1))
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

enum class Direction {
    LEFT {
        override fun move(): Position {
            return Position(-1,0)
        }
    },

    UP {
        override fun move(): Position {
            return Position(0,1)
        }
    },

    DOWN {
        override fun move(): Position {
            return Position(0,-1)
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

