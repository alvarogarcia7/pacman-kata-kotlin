package com.kata.pacman

import org.junit.Assert
import org.junit.Test

class RepresentationTest {

    @Test
    fun `grid of 5*5 with pacman in the center looking up`() {
        var grid = Grid(Dimension(5, 5))
        val pacman = Pacman(Position(2, 2), Direction.UP, grid)
        val expected = arrayOf(
                ". . . . .",
                ". . . . .",
                ". . v . .",
                ". . . . .",
                ". . . . .")

        Assert.assertArrayEquals(expected, grid.representation())
    }

    @Test
    fun `grid of 3*3 with pacman in the center looking up`() {
        var grid = Grid(Dimension(3, 3))
        val pacman = Pacman(Position(1, 1), Direction.UP, grid)
        val expected = arrayOf(
                ". . .",
                ". v .",
                ". . .")

        Assert.assertArrayEquals(expected, grid.representation())
    }

    @Test
    fun `grid of 3*3 with pacman in the center looking down`() {
        var grid = Grid(Dimension(3, 3))
        val pacman = Pacman(Position(1, 1), Direction.DOWN, grid)
        val expected = arrayOf(
                ". . .",
                ". ^ .",
                ". . .")

        Assert.assertArrayEquals(expected, grid.representation())
    }
}


