package com.example.androiddevchallenge.constants

object Routes {
    const val List = "list"
    const val Detail = "detail/{id}"
    const val Add = "add"
    const val My = "my"

    fun detailPath(id: Int): String {
        return Detail.replace("{id}", id.toString())
    }
}