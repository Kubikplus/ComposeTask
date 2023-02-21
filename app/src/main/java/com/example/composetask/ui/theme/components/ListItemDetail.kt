package com.example.composetask.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetask.R
import com.example.composetask.data.PostItem
import com.example.composetask.ui.theme.Shapes

@Composable
fun ListItemDetail(item: PostItem, isSelectable: Boolean, modifier: Modifier = Modifier) {
    val semanticsModifier =
        if (isSelectable)
            modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .semantics { selected = true }
        else modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    Card(
        modifier = semanticsModifier
            .clickable { },
        elevation = 10.dp,
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.White
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                ItemName(item = item)
                ItemDetail(item = item)
                Divider(
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
                Elements(item)


            }

        }


    }

}

@Composable
fun ItemDetail(item: PostItem) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Text(text = "Postal provider", modifier = Modifier.weight(1f), fontSize = 14.sp)
            Text(text = "Postal account", modifier = Modifier.weight(1f), fontSize = 14.sp)
            Text(text = "Mail date", modifier = Modifier.weight(1f), fontSize = 14.sp)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = item.postalProvider,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = item.postalAccount.toString(),
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )
            Text(text = "24/04/2022", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Text(text = "Product", modifier = Modifier.weight(1f), fontSize = 14.sp)
            Text(text = "Classes", modifier = Modifier.weight(1f), fontSize = 14.sp)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Text(text = item.product, modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
            Text(
                text = item.productClass,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Text(text = "Costumer", modifier = Modifier.weight(1f), fontSize = 14.sp)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = item.customerName,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
fun Elements(item: PostItem) {
    var isCardVisible by remember { mutableStateOf(true) }
    if(isCardVisible) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp, top = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Example text",
                    modifier = Modifier.weight(1f)
                )
                SquareCheckbox()
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "No ${item.subItems.count}",
                    modifier = Modifier.weight(1f)
                )
                Text(text = "MM SI CA", modifier = Modifier.weight(1f))
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = { isCardVisible = !isCardVisible },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .size(35.dp),
            backgroundColor = Color.White
        ) {
            if (isCardVisible) {
                Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Show")
            }else Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Hide")
        }
    }
}

@Composable
fun SquareCheckbox() {
    var checked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.size(25.dp)
    ) {
        Surface(
            border = BorderStroke(1.dp, Color.Gray),
            shape = RoundedCornerShape(5.dp),
            color = Color.White,
            modifier = Modifier.size(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = { checked = !checked })
            ) {
                if (checked) {
                    Icon(
                        Icons.Default.Check, contentDescription = "Checked",
                        tint = Color.Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .background(Color.White)
                    )
                }
            }
        }
    }
}



