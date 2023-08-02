package com.kroshka.myapp

enum class GameItems {
    Rock, Paper, Scissors;

    companion object {
        fun getRandomChoice(): GameItems {
            return GameItems.values().random()
        }
    }
}