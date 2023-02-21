package com.example.composetask.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetask.R

@Composable
fun BottomButtons(
    onCancelClicked: () -> Unit,
    onContinueClicked: () -> Unit
) {
    Surface(
        color = Color.White,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "CANCEL",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable(onClick = onCancelClicked)
                    .padding(0.dp, 0.dp, 100.dp, 0.dp),
                color = colorResource(id = R.color.mainColor)
            )

            Button(
                onClick = onContinueClicked,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(91, 116, 141, 255)),
                modifier = Modifier
                    .height(40.dp)
                    .widthIn(min = 128.dp)

            ) {
                Text(text = "CONTINUE", color = Color.White)
            }
        }
    }

}