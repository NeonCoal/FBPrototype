package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dicePairs: List<DicePair>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize dice pairs
        val dicePair1 = DicePair(
            findViewById(R.id.roll_button),
            findViewById(R.id.dice_image)
        )

        val dicePair2 = DicePair(
            findViewById(R.id.roll_button2),
            findViewById(R.id.dice_image2)
        )

        val dicePair3 = DicePair(
            findViewById(R.id.roll_button3),
            findViewById(R.id.dice_image3)
        )

        val dicePair4 = DicePair(
            findViewById(R.id.roll_button4),
            findViewById(R.id.dice_image4)
        )

        dicePairs = listOf(dicePair1, dicePair2, dicePair3, dicePair4)

        // Set click listeners
        dicePairs.forEach { pair ->
            pair.button.setOnClickListener {
                rollDice(pair)
            }
        }
    }

    private fun rollDice(pair: DicePair) {
        val drawableResource = when (pair.index) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        pair.imageView.setImageResource(drawableResource)
        pair.index = if (pair.index < 6) pair.index + 1 else 1
    }
}