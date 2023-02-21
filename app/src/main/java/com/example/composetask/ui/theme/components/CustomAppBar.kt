package com.example.composetask.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composetask.R

@Composable
fun CustomAppBar(onToggle: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.mainColor))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "UserName",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Logged in 14/02 11:45",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp, 24.dp, 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            LogOutAction(onTouch = { onToggle() })

        }

    }

}

@Composable
fun LogOutAction(onTouch: () -> Unit) {
    val icon = painterResource(id = R.drawable.baseline_logout_24)
    Icon(
        painter = icon, contentDescription = null,
        modifier = Modifier
            .size(30.dp, 30.dp)
            .clickable(onClick = onTouch)
    )
}
