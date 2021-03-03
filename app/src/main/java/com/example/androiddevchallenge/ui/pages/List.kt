package com.example.androiddevchallenge.ui.pages

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.components.CatList
import com.example.androiddevchallenge.viewModels.CatListViewModel

@Composable
fun List(onItemClick: (Int) -> Unit) {
    val vm: CatListViewModel = viewModel()
    CatList(cats = vm.cats, onItemClick = onItemClick)
}