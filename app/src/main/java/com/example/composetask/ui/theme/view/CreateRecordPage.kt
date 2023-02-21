package com.example.composetask.ui.theme.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetask.R
import com.example.composetask.data.PostItem
import com.example.composetask.data.SubItem
import com.example.composetask.ui.theme.components.CustomAppBar
import com.example.composetask.ui.theme.components.ListItemDetail
import com.example.composetask.ui.theme.components.MainPageListItems

@Composable
fun CreateRecordPage() {
    val modifier: Modifier = Modifier
    val postItem = PostItem("Bench1",
        10,
        "Royal mail",
        285502007,
        "STL",
        "1st",
        "Paragon Customer",
        subItems = SubItem("SRAA-WIWHD-WHKJDHA",false,30)
    )
    val lipsticks = listOf(postItem, postItem)
    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        CustomAppBar(onToggle = {})
        TextStatus("Create postal record")
        TextDescription()
        LazyColumn(modifier = modifier, state = rememberLazyListState()) {
            itemsIndexed(lipsticks) { index, pack ->
                ListItemDetail(item = pack, isSelectable = false, modifier)
            }
        }



    }
}

@Composable
fun TextDescription() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp, 0.dp, 0.dp, 14.dp)
    ) {
        Text(
            text = "GRID",
            Modifier.weight(1f),
            color = colorResource(id = R.color.mainColor),
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Qty of files",
            Modifier.weight(1.2f),
            color = colorResource(id = R.color.mainColor), fontWeight = FontWeight.Light
        )
    }

}