package com.kata.pacman

enum class Direction {
    LEFT {
        override fun move(): Position = Position(-1,0)
    },

    UP {
        override fun move(): Position = Position(0,1)
    },

    DOWN {
        override fun move(): Position = Position(0,-1)
    },

    RIGHT {
        override fun move(): Position = Position(1,0)
    };

    abstract fun move() : Position
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

    fun  simplify(position: Position): Position {
        var result = position
        fun wrapX(position: Position, threshold: Int): Position {
            if(position.beforeTheX()){
                return increaseXAxis(position)
            } else if(position.atOrPastTheX(threshold)){
                return decreaseXAxis(position)
            }
            return position
        }

        fun wrapY(position: Position, threshold: Int) : Position {
            if (position.beforeTheY()) {
                return increaseYAxis(position)
            } else if (position.atOrPastTheY(threshold)) {
                return decreaseYAxis(position)
            }
            return position
        }
        return wrapY(wrapX(result, dimension.x), dimension.y)
    }


    private fun decreaseXAxis(position: Position): Position = position.copy(x = position.x - dimension.x)
    private fun increaseXAxis(position: Position): Position = position.copy(x = position.x + dimension.x)

    private fun decreaseYAxis(position: Position): Position = position.copy(y = position.y - dimension.y)
    private fun increaseYAxis(position: Position): Position = position.copy(y = position.y + dimension.y)
}

class Dimension(val x: Int, val y: Int) {
}

class Pacman(private var position: Position, private var direction: Direction, private var grid: Grid) {

    fun move() {
        position = grid.simplify(position.add(direction.move()))
    }

    fun position() = position

    fun  face(newDirection: Direction) {
        this.direction = newDirection
    }

    fun facing() = direction

}
