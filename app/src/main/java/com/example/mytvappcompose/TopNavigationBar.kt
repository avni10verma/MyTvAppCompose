package com.example.mytvappcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TopNavigationBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
       
        Image(painter = painterResource(id = R.drawable.user), contentDescription = "User")
        Text(text = "Home", style = MaterialTheme.typography.bodySmall)
        Text(text = "Apps", style = MaterialTheme.typography.bodySmall)
        Text(text = "Favourites", style = MaterialTheme.typography.bodySmall)
        Text(text = "Movies", style = MaterialTheme.typography.bodySmall)
        Image(painter = painterResource(id = R.drawable.search22), contentDescription = "Search")
        Image(painter = painterResource(id = R.drawable.setting2), contentDescription = "Settings")


    }
}