package com.example.instagram

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagram.model.Friends
import com.example.instagram.ui.theme.InstagramTheme

@Composable
fun SimpleRecycleView() {
    val myList = listOf("Michelle", "Natalia", "Martina", "Jessica", "Ashley")
    LazyColumn() {
        item { Text(text = "Header") }
        items(myList) {
            Text(text = "$it")
        }
        item { Text(text = "Footer") }

    }
}

@Composable
fun ItemFriends(friends: Friends, onItemSelected: (Friends) -> Unit) {
    Card(border = BorderStroke(2.dp, color = Color.LightGray), modifier = Modifier.width(200.dp)) {
        Column() {
            Image(
                painter = painterResource(id = friends.photo),
                contentDescription = "${friends.friendName} Picture",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = friends.friendName, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = friends.nickName, modifier = Modifier.align(Alignment.CenterHorizontally))

        }
    }
}

fun getFriends(): List<Friends> {
    return listOf(
        Friends("Michelle", "Michy", 20, R.drawable.leo),
        Friends("Natalia", "Natty", 19, R.drawable.mikey),
        Friends("Zahúl", "Zahwy", 22, R.drawable.donnie),
        Friends("Ashley", "Ash", 21, R.drawable.raph),
    )
}

@Composable
fun FriendsView(){
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
        items(getFriends()) { Friends ->
            ItemFriends(friends = Friends){
                Toast.makeText(
                    context,
                    it.friendName,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FriendsViewGrid(){
    val context = LocalContext.current
    LazyVerticalGrid(cells = GridCells.Adaptive(300.dp), content =  {

        items(getFriends()) { Friends ->
            ItemFriends(friends = Friends){
                Toast.makeText(
                    context,
                    it.friendName,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    })
}


