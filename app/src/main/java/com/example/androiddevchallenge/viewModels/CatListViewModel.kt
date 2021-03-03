package com.example.androiddevchallenge.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Cat

class CatListViewModel : ViewModel() {
    val likeList by mutableStateOf(mutableListOf<Cat>())
    val cats by mutableStateOf(listOf(
        Cat(
            id = 1,
            name = "1",
            age = "1",
            desc = "",
            img = R.drawable.c1,
        ),
        Cat(
            id = 2,
            name = "2",
            age = "2",
            desc = "",
            img = R.drawable.c2,
        ),
        Cat(
            id = 3,
            name = "3",
            age = "3",
            desc = "",
            img = R.drawable.c3,
        ),
        Cat(
            id = 4,
            name = "4",
            age = "4",
            desc = "",
            img = R.drawable.c4,
        ),
        Cat(
            id = 5,
            name = "5",
            age = "5",
            desc = "",
            img = R.drawable.c5,
        ),
        Cat(
            id = 6,
            name = "6",
            age = "6",
            desc = "",
            img = R.drawable.c6,
        ),
    ))

    fun add(cat: Cat) {
        likeList.add(cat)
    }

    fun del(cat: Cat) {
        likeList.remove(cat)
    }
}