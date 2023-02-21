package com.example.composetask.data

data class PostItem(
    val name:String,
    val availablePack: Int,
    val postalProvider:String,
    val postalAccount:Int,
    val product: String,
    val productClass:String,
    val customerName:String,
    val subItems: SubItem
)
