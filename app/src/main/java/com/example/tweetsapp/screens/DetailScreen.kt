package com.example.tweetsapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsapp.viewmodels.DetailViewmodel

@Composable
fun DetailScreen() {
    val detailViewmodel: DetailViewmodel = hiltViewModel()
    val tweets = detailViewmodel.tweets.collectAsState()
    LazyColumn(content = {
        items(tweets.value) {
            TweetListItem(tweet = it.toString())
        }
    })

}

@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, color = Color(0xFFCCCCCC)),
        content = {
            Text(
                text = tweet,
                modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodySmall
            )
        }
    )
}