package com.kata.pacman

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

class Grid(dimension: Dimension) {

}

class Dimension(x: Int, y: Int) {

}

class Pacman {
    private var position: Position
    private var direction: Direction

    constructor(position: Position, direction: Direction, grid: Grid) {
        this.position = position
        this.direction = direction
    }

    fun move() {
        position.add(direction.move())
    }

    fun position(): Position {
        return position
    }

    fun  face(newDirection: Direction) {
        this.direction = newDirection
    }

    fun facing(): Direction {
        return direction
    }

}
