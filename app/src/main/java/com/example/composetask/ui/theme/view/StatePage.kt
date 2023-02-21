package com.example.composetask.ui.theme.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun StatePage() {
    ColorBox()

}


@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .background(Color.Yellow)
        .clickable {}) {
    }

}