package com.kroshka.myapp

enum class GameItems {
    // all items
    Rock, Paper, Scissors;

    companion object {
        // random item
        fun getRandomChoice(): GameItems {
            return GameItems.values().random()
        }
    }
}