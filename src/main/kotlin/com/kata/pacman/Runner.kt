package com.kata.pacman

class Runner(val ui: UI) {
    fun loop() {
        ui.clean()
    }

}

interface UI {
    fun clean()
}