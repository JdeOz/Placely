package com.jd.placely.presentation.main_feed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jd.placely.presentation.components.PostItem
import com.jd.placely.presentation.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController,
    viewModel: MainFeedViewModel = hiltViewModel()
) {
    val posts by viewModel.posts.observeAsState(emptyList())

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp) // Dejar espacio para la NavigationBar
        ) {
            items(posts.size) { post ->
                PostItem(post = posts[post])
            }
        }

        val icons = listOf(
            Icons.Filled.Map,
            Icons.Filled.Home,
            Icons.Filled.Search,
            Icons.Filled.CalendarMonth,
            Icons.Filled.Person
        )
        var selectedItem by remember { mutableStateOf(1) }

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(56.dp),
        ) {
            icons.forEachIndexed { index, icon ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            icon,
                            contentDescription = "",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        navController.navigate(Screen.MapScreen.route)
                    }
                )
            }
        }
    }
}



