package com.kata.pacman

class Runner(val ui: UI) {
    fun loop() {
        ui.clean()
        ui.print()
    }

}

interface UI {
    fun clean()
    fun print()
}