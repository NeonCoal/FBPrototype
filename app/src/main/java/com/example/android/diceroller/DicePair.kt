package com.example.android.diceroller

import android.widget.Button
import android.widget.ImageView

data class DicePair(
    val button: Button,
    val imageView: ImageView,
    var index: Int = 1,
    val drawableResources: List<Int>
)

