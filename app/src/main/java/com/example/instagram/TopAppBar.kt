package com.example.instagram

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar( onItemSelected =  {
            coroutineScope.launch {
                scaffoldState
                    .snackbarHostState
                    .showSnackbar("You clicked $it")
            }
        }, onOpenDrawer = {
            coroutineScope.launch {
                scaffoldState.drawerState.open()
            }
        } )
    }
        , scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigationMenu() },
        floatingActionButton = { MyFABs()},
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerContent = { MyDrawer{
            coroutineScope.launch {
                scaffoldState.drawerState.close()
            }
        }},
        drawerGesturesEnabled = false
    ) {

    }
}

@Composable
fun MyTopAppBar(onItemSelected: (String) -> Unit, onOpenDrawer:()->Unit) {
    TopAppBar(
        title = { Text(text = "My Top App Bar") },
        backgroundColor = Color(0xFF0F2330),
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = { onOpenDrawer() }) {
                Icon(
                    imageVector =
                    Icons.Default.Menu,
                    contentDescription = "Menu"
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
    BottomNavigation(
        backgroundColor = Color(0xFF0F2330),
        contentColor = Color.White
    ) {
        BottomNavigationItem(selected = selected == 0,
            onClick = { selected = 0 }, icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }, label = { Text(text = "Home") })

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
        backgroundColor = Color(0xFF0F2330),
        contentColor = Color.White

    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: ()->Unit){
    val myList = listOf("Menus", "Menu 1", "Menu 2", "Menu 3")
    Column(Modifier.padding(8.dp)) {
        myList.forEach {
            Text(text = it, modifier = Modifier
                .clickable { onCloseDrawer() }
                .fillMaxWidth()
                .padding(8.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    InstagramTheme {
        ScaffoldExample()
    }
}