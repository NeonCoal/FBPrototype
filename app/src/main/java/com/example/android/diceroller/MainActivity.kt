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

        // Initialize dice pairs with different drawable resources
        val dicePair1 = DicePair(
            findViewById(R.id.roll_button1),
            findViewById(R.id.dice_image1),
            drawableResources = listOf(
                R.drawable.hat1,
                R.drawable.hat2,
                R.drawable.hat3
            )
        )

        val dicePair2 = DicePair(
            findViewById(R.id.roll_button2),
            findViewById(R.id.dice_image2),
            drawableResources = listOf(
                R.drawable.shirt1,
                R.drawable.shirt2,
                R.drawable.shirt3
            )
        )

        val dicePair3 = DicePair(
            findViewById(R.id.roll_button3),
            findViewById(R.id.dice_image3),
            drawableResources = listOf(
                R.drawable.pants1,
                R.drawable.pants2,
                R.drawable.pants3
            )
        )

        val dicePair4 = DicePair(
            findViewById(R.id.roll_button4),
            findViewById(R.id.dice_image4),
            drawableResources = listOf(
                R.drawable.shoe1,
                R.drawable.shoe2,
                R.drawable.shoe3
            )
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
        val drawableResource = pair.drawableResources[pair.index - 1]
        pair.imageView.setImageResource(drawableResource)
        pair.index = if (pair.index < 3) pair.index + 1 else 1
    }
}