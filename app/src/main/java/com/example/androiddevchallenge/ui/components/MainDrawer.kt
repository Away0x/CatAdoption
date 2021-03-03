package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.constants.Routes
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun ColumnScope.MainDrawer(onNavigate: (String) -> Unit) {
    Spacer(Modifier.statusBarsHeight())
    Divider()
    Button(onClick = { onNavigate(Routes.List) }) {
        Text(text = Routes.List)
    }
    Button(onClick = { onNavigate(Routes.Detail) }) {
        Text(text = Routes.Detail)
    }
}