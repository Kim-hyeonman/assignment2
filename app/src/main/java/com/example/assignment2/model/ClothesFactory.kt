package com.example.assignment2.model

import androidx.compose.runtime.mutableStateListOf
import com.example.assignment2.R

object ClothesFactory {
    fun makeOnoffClothes() = mutableStateListOf(
        Clothes(R.drawable.body,"body"),
        Clothes(R.drawable.eyes,"eyes"),
        Clothes(R.drawable.arms,"arms"),
        Clothes(R.drawable.eyebrows,"eyebrows"),
        Clothes(R.drawable.glasses,"glasses"),
        Clothes(R.drawable.mouth,"mouth"),
        Clothes(R.drawable.nose,"nose"),
        Clothes(R.drawable.ears,"ears"),
        Clothes(R.drawable.hat,"hat"),
        Clothes(R.drawable.mustache,"mustache"),
        Clothes(R.drawable.shoes,"shoes")
    )
}