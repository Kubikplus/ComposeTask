package com.example.composetask.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composetask.data.PostItem

@Composable
fun MainPageListItems(item: PostItem, isSelected: Boolean) {
    Column(modifier = Modifier.fillMaxSize()) {
        ListItems(item = item, isSelected = isSelected)
    }


}

@Composable
fun ListItems(
    item: PostItem,
    isSelectable: Boolean = false,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val semanticsModifier =
        if (isSelectable)
            modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .semantics { selected = isSelected }
        else modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    Card(
        modifier = semanticsModifier
            .clickable { }
            .padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            ItemName(item = item)

        }
    }
}

@Composable
fun ItemName(item: PostItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    ) {
        Text(
            text = item.name,
            style = MaterialTheme.typography.subtitle2,
            color = Color.Black,
            textAlign = TextAlign.Start
        )

        Text(
            modifier = Modifier.weight(1f),
            text = item.availablePack.toString(),
            style = MaterialTheme.typography.subtitle2,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        RoundCheckbox()
    }
}

@Composable
fun RoundCheckbox() {
    var checked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.size(25.dp)
    ) {
        Surface(
            shape = CircleShape,
            border = BorderStroke(1.dp,Color.Gray),
            color = if (checked) Color.White else Color.White,
            modifier = Modifier.size(32.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = { checked = !checked })
            ) {
                if (checked) {
                    Icon(Icons.Default.Check, contentDescription = "Checked",
                        tint = Color.Black,
                        modifier = Modifier.align(Alignment.Center).background(Color.White))
                }
            }
        }
    }
}