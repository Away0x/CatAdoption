package com.example.androiddevchallenge.ui.pages

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.components.CatDetail
import com.example.androiddevchallenge.viewModels.CatListViewModel

@Composable
fun Detail(id: Int) {
    val vm: CatListViewModel = viewModel()
    val cat = vm.cats.find { it.id == id }
    val like = vm.likeList.find { it == cat }

    if (cat == null) {
        Text(text = "Cat not found")
    } else {
        CatDetail(
            cat = cat,
            isLike = like != null,
            onLike = { vm.add(it) },
            onCancel = { vm.del(it) },
        )
    }
}