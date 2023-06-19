package com.jd.placely.presentation.map

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.jd.placely.presentation.components.MarkItem

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MapViewModel = hiltViewModel()
) {
    val marks by viewModel.marks.observeAsState(emptyList())

    Box(modifier = Modifier.fillMaxSize()) {

        val ucsp = LatLng(-16.390090173763063, -71.53534142244479)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(ucsp, 15f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize().padding(bottom = 56.dp),
            cameraPositionState = cameraPositionState
        ) {
            for (item in marks) MarkItem(mark = item)
        }

        //------------------------


        //-------------------------

        val icons = listOf(
            Icons.Filled.Map,
            Icons.Filled.Home,
            Icons.Filled.Search,
            Icons.Filled.CalendarMonth,
            Icons.Filled.Person
        )
        var selectedItem by remember { mutableStateOf(0) }

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
                    onClick = { selectedItem = index }
                )
            }
        }
    }
}
