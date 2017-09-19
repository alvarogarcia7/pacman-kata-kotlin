package com.kata.pacman

enum class Direction {
    LEFT {
        override fun move(): Position = Position(-1,0)
        override fun pacManRepresentation(): String = ">"
    },

    UP {
        override fun move(): Position = Position(0,1)
        override fun pacManRepresentation(): String = "v"
    },

    DOWN {
        override fun move(): Position = Position(0,-1)
        override fun pacManRepresentation(): String = "^"
    },

    RIGHT {
        override fun move(): Position = Position(1,0)
        override fun pacManRepresentation(): String = "<"
    };

    abstract fun move() : Position
    abstract fun pacManRepresentation() : String
}

data class Position(var x: Int, var y: Int) {
    fun add(move: Position): Position {
        this.x += move.x
        this.y += move.y
        return this
    }

    fun beforeTheX(): Boolean = this.x < 0
    fun atOrPastTheX(threshold: Int): Boolean = this.x >= threshold

    fun beforeTheY(): Boolean = this.y < 0
    fun atOrPastTheY(threshold: Int): Boolean = this.y >= threshold
}

class Grid(val dimension: Dimension) {

    var pacman: Pacman? = null

    fun  simplify(position: Position): Position {
        return wrapY(wrapX(position, dimension.x), dimension.y)
    }

    private fun wrapX(position: Position, threshold: Int): Position {
        if (position.beforeTheX()) {
            return increaseXAxis(position)
        } else if (position.atOrPastTheX(threshold)) {
            return decreaseXAxis(position)
        }
        return position
    }

    private fun wrapY(position: Position, threshold: Int) : Position {
        if (position.beforeTheY()) {
            return increaseYAxis(position)
        } else if (position.atOrPastTheY(threshold)) {
            return decreaseYAxis(position)
        }
        return position
    }

    private fun decreaseXAxis(position: Position): Position = position.copy(x = position.x - dimension.x)
    private fun increaseXAxis(position: Position): Position = position.copy(x = position.x + dimension.x)

    private fun decreaseYAxis(position: Position): Position = position.copy(y = position.y - dimension.y)
    private fun increaseYAxis(position: Position): Position = position.copy(y = position.y + dimension.y)

    fun representation(): Array<String> {

        val x =(0).rangeTo(dimension.x-1).map(fun(row:Int): String{
            val x2 = (0).rangeTo(dimension.y-1).map(fun(col:Int): String {
                if(this.pacman?.position()?.x == row && this.pacman?.position()?.y == col){
                    return pacman?.facing()?.pacManRepresentation()!!
                }
                return "."
            })
            return x2.joinToString(" ")
        })

        return x.toTypedArray()
    }

}

class Dimension(val x: Int, val y: Int)

class Pacman {

    private var position: Position
    private var direction: Direction
    private var grid: Grid

    constructor(position: Position, direction: Direction, grid: Grid) {
        this.position = position
        this.direction = direction
        this.grid = grid
        grid.pacman = this
    }

    fun move() {
        position = grid.simplify(position.add(direction.move()))
    }

    fun  face(newDirection: Direction) {
        this.direction = newDirection
    }

    fun position() = position

    fun facing() = direction
}
