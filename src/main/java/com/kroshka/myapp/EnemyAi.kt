package com.kroshka.myapp

class EnemyAi : Player() {
    fun enemyAiChoice() {
        currentChoice = GameItems.getRandomChoice()
    }
}