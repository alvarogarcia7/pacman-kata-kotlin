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
    fun add(move: Position): Position {
        this.x += move.x
        this.y += move.y
        return this
    }

    fun atOrPastTheX(threshold: Int): Boolean {
        return this.x >= threshold
    }

    fun beforeTheX(threshold: Int): Boolean = this.x < threshold
    fun atOrPastTheY(threshold: Int): Boolean = this.y >= threshold
}

class Grid(val dimension: Dimension) {

    fun  simplify(position: Position): Position {
        var result = position
        if(position.atOrPastTheX(dimension.x)){
            result = decreaseXAxis(position)
        }
        if(position.beforeTheX(dimension.x)){
            result = increaseXAxis(position)
        }
        if(position.atOrPastTheY(dimension.y)){
            result = decreaseYAxis(position)
        }
        return result
    }

    private fun decreaseYAxis(position: Position): Position = position.copy(y = position.y - dimension.y)

    private fun increaseXAxis(position: Position): Position = position.copy(x = position.x + dimension.x)

    private fun decreaseXAxis(position: Position): Position {
        return position.copy(x = position.x - dimension.x)
    }

}

class Dimension(val x: Int, val y: Int) {
}

class Pacman {
    private var position: Position
    private var direction: Direction
    private var grid: Grid

    constructor(position: Position, direction: Direction, grid: Grid) {
        this.position = position
        this.direction = direction
        this.grid = grid
    }

    fun move() {
        position = grid.simplify(position.add(direction.move()))
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
