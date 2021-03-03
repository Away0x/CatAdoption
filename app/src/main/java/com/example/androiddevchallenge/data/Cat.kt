package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

data class Cat(
    val id: Int,
    val name: String,
    val age: String,
    val desc: String,
    @DrawableRes val img: Int,
)
