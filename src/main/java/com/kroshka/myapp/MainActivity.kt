package com.kroshka.myapp

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kroshka.myapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val player2: EnemyAi = EnemyAi()
    val player1: Player1 = Player1()

    private fun showEnemyChoice() {
        when (player2.currentChoice) {
            GameItems.Rock -> binding.enemyChoiceImage.setImageResource(R.drawable.rock)
            GameItems.Paper -> binding.enemyChoiceImage.setImageResource(R.drawable.paper)
            GameItems.Scissors -> binding.enemyChoiceImage.setImageResource(R.drawable.scissors)
            null -> binding.playerChoiceImage.setImageDrawable(null)
        }
    }

    private fun showPlayerChoice() {
        when (player1.currentChoice) {
            GameItems.Rock -> binding.playerChoiceImage.setImageResource(R.drawable.rock)
            GameItems.Paper -> binding.playerChoiceImage.setImageResource(R.drawable.paper)
            GameItems.Scissors -> binding.playerChoiceImage.setImageResource(R.drawable.scissors)
            null -> binding.playerChoiceImage.setImageDrawable(null)
        }
    }

    // val items = mapOf("Rock" to "Scissors", "Scissors" to "Paper", "Paper" to "Rock")

    fun getWinner(player1: Player, player2: Player): Player? {
        var winner: Player? = null
        if (player1.currentChoice == player2.currentChoice) {
            return null
        } else if (
            (player1.currentChoice == GameItems.Rock && player2.currentChoice == GameItems.Scissors) ||
            (player1.currentChoice == GameItems.Scissors && player2.currentChoice == GameItems.Paper) ||
            (player1.currentChoice == GameItems.Paper && player2.currentChoice == GameItems.Rock)
        ) {
            return player1
        } else if (
            (player2.currentChoice == GameItems.Rock && player1.currentChoice == GameItems.Scissors) ||
            (player2.currentChoice == GameItems.Scissors && player1.currentChoice == GameItems.Paper) ||
            (player2.currentChoice == GameItems.Paper && player1.currentChoice == GameItems.Rock)
        ) {
            return player2
        }
        return winner
    }

    fun getScore() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.stoneButton.setOnClickListener {
            player1.currentChoice = GameItems.Rock
            showPlayerChoice()
            player2.enemyAiChoice()
            showEnemyChoice()
        }
        binding.scissorsButton.setOnClickListener {
            player1.currentChoice = GameItems.Scissors
            showPlayerChoice()
            player2.enemyAiChoice()
            showEnemyChoice()
        }
        binding.paperButton.setOnClickListener {
            player1.currentChoice = GameItems.Paper
            showPlayerChoice()
            player2.enemyAiChoice()
            showEnemyChoice()
        }

        // android.text="lavacat"
        setContentView(binding.root)
    }
}
