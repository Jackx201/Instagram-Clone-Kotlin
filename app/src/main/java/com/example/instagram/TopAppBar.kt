package com.example.instagram

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.instagram.ui.theme.InstagramTheme
import kotlinx.coroutines.launch
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar() {
            coroutineScope.launch {
                scaffoldState
                    .snackbarHostState
                    .showSnackbar("You clicked $it")
            }
        }//TopBar
    }//Top Bar
        , scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigationMenu() },
        floatingActionButton = { MyFABs()},
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {

    }
}

@Composable
fun MyTopAppBar(onItemSelected: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "My Top App Bar") },
        //backgroundColor = Color.Magenta,
        navigationIcon = {
            IconButton(onClick = { onItemSelected("Back") }) {
                Icon(
                    imageVector =
                    Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },

        actions = {
            IconButton(onClick = { onItemSelected("Search") }) {
                Icon(
                    imageVector =
                    Icons.Default.Search,
                    contentDescription = "Search"
                )
            }

            IconButton(onClick = { onItemSelected("Close") }) {
                Icon(
                    imageVector =
                    Icons.Default.Close,
                    contentDescription = "Close"
                )
            }
        }
    )
}

@Composable
fun MyBottomNavigationMenu() {
    var selected by remember {
        mutableStateOf(0)
    }
    BottomNavigation() {
        BottomNavigationItem(selected = selected == 0,
            onClick = { selected = 0 }, icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }, label = { Text(text = "Home") })

        BottomNavigationItem(selected == 1,
            onClick = { selected = 1 }, icon = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Home")
            }, label = { Text(text = "Fav") })

        BottomNavigationItem(selected = selected == 2,
            onClick = { selected = 2 }, icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Home")
            }, label = { Text(text = "People") })
    }
}

@Composable
fun MyFABs() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color.DarkGray,
        contentColor = Color.White

    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    InstagramTheme {
        ScaffoldExample()
    }
}