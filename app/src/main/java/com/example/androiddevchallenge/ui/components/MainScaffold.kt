package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MainScaffold(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onNavButtonClick: () -> Unit,
    onNavigate: (String) -> Unit,
    onFloatingActionButtonClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainTopAppBar { onNavButtonClick() }
        },
        drawerContent = { MainDrawer(onNavigate) },
        content = content,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onFloatingActionButtonClick() },
            ) {
                Text(text = "ADD", color = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    )
}