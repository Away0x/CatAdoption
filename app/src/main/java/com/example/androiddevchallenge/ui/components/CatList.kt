package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Cat

@Composable
fun CatList(cats: List<Cat>, onItemClick: (Int) -> Unit) {
    LazyColumn(
        Modifier.background(MaterialTheme.colors.secondary),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(cats) { cat ->
            CatItem(
                cat = cat,
                modifier = Modifier.fillMaxWidth().clickable {
                    onItemClick(cat.id)
                }
            )
        }
    }
}

@Composable
fun CatItem(cat: Cat, modifier: Modifier = Modifier) {
    Card(modifier) {
        Image(
            painterResource(cat.img),
            "img ${cat.id} - ${cat.name}",
            Modifier.size(120.dp),
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(8.dp)) {
            Text(cat.name, style = MaterialTheme.typography.h4)
            Text(cat.desc)
            Text(cat.age)
        }
    }
}