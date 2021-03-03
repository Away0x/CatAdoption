package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Cat

@Composable
fun CatDetail(cat: Cat, isLike: Boolean, onLike: (Cat) -> Unit, onCancel: (Cat) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
    ) {
        Box {
            Image(
                painterResource(cat.img),
                "img ${cat.id} - ${cat.name}",
                Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Button(
                {
                    print(isLike)
                    if (isLike) onCancel(cat) else onLike(cat)
                },
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = if (isLike) "Cancel" else "Like")
            }
        }
        Column(Modifier.padding(16.dp, 8.dp)) {
            Text("Name: ${cat.name}", style = MaterialTheme.typography.h3)
            ProvideTextStyle(MaterialTheme.typography.h5) {
                Text("Age: ${cat.age}")
                Text("Description: ${cat.desc}")
            }
        }
    }
}