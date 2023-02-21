package com.example.composetask.ui.theme.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetask.R
import com.example.composetask.data.PostItem
import com.example.composetask.data.SubItem
import com.example.composetask.ui.theme.components.BottomButtons
import com.example.composetask.ui.theme.components.CustomAppBar
import com.example.composetask.ui.theme.components.MainPageListItems
import com.example.composetask.ui.theme.navigation.Screen

@Composable
fun MainPage(navController: NavController, togglePress: () -> Unit) {
    val postItem = PostItem(
        "Bench1", 10, "Royal mail", 285502007, "STL", "1st", "Paragon Customer",
        subItems = SubItem("dhahdw", false, 20)
    )
    val lipsticks = listOf(postItem, postItem, postItem)

    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        CustomAppBar(onToggle = togglePress)
        TextStatus("Fullfill orders")
        MainPageList(packs = lipsticks, modifier = Modifier.weight(1f))
        BoxWithConstraints(contentAlignment = Alignment.BottomCenter) {
            BottomButtons(onCancelClicked = {}, onContinueClicked = {
                navController.navigate(Screen.CreateRecord.route)
            })
        }
    }
}


@Composable
fun MainPageList(packs: List<PostItem>, modifier: Modifier = Modifier) {
    var isCardVisible by remember { mutableStateOf(true) }
    if(isCardVisible) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 10.dp, end = 24.dp, bottom = 5.dp),
            backgroundColor = Color.White,
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            PacksStatus()
        }
        Divider(color = Color.Black, modifier = Modifier.padding(24.dp, 5.dp, 24.dp, 10.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp, 0.dp, 0.dp, 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Bench",
            Modifier.weight(1f),
            color = colorResource(id = R.color.mainColor),
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Available to pack",
            Modifier.weight(1.2f),
            color = colorResource(id = R.color.mainColor), fontWeight = FontWeight.Light
        )
        FloatingActionButton(
            onClick = { isCardVisible = !isCardVisible },
            modifier = Modifier
                .padding(start = 24.dp, top = 10.dp, end = 24.dp)
                .size(35.dp),
            backgroundColor = Color.White
        ) {
            if (isCardVisible) {
                Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Show")
            }else Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Hide")
        }

    }
    LazyColumn(modifier = modifier, state = rememberLazyListState()) {
        itemsIndexed(packs) { index, pack ->
            MainPageListItems(item = pack, isSelected = false)
        }
    }

}

@Composable
fun PacksStatus() {
    Column(Modifier.padding(15.dp)) {
        Row(
            modifier = Modifier
                .background(color = colorResource(id = R.color.textBackground))
                .padding(5.dp)
        ) {
            Text(
                text = "Available orders to pack",
                color = Color.Black,
                modifier = Modifier.weight(2f),
                fontWeight = FontWeight.Light
            )
            Text(text = "39/59", color = Color.Black, fontWeight = FontWeight.Bold)
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                text = "Orders pending to pack",
                color = Color.Black,
                modifier = Modifier.weight(2f),
                fontWeight = FontWeight.Light
            )
            Text(text = "11", color = Color.Black, fontWeight = FontWeight.Bold)
        }
        Row(
            modifier = Modifier
                .background(color = colorResource(id = R.color.textBackground))
                .padding(5.dp)
        ) {
            Text(
                text = "Total item quantity",
                color = Color.Black,
                modifier = Modifier.weight(2f),
                fontWeight = FontWeight.Light
            )
            Text(text = "160", color = Color.Black, fontWeight = FontWeight.Bold)
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                text = "Item different types",
                color = Color.Black,
                modifier = Modifier.weight(2f),
                fontWeight = FontWeight.Light
            )
            Text(text = "11", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TextStatus(currentOperation: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 10.dp, 24.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier.padding(),
            text = currentOperation,
            style = MaterialTheme.typography.subtitle2,
            color = colorResource(id = R.color.mainColor),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(),
            text = "Customer from Dum",
            style = MaterialTheme.typography.subtitle2,
            color = colorResource(id = R.color.locationText),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Online",
            color = colorResource(id = R.color.textColor),
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Bold,
        )
    }
    Divider(color = Color.Black, modifier = Modifier.padding(24.dp, 5.dp, 24.dp, 5.dp))
}
