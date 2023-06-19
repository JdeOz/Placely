package com.jd.placely.presentation.components

import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.jd.placely.domain.model.Mark

@Composable
fun MarkItem(mark: Mark) {
    Marker(
        state = MarkerState(position = LatLng(mark.latitud, mark.longitud)),
        title = "${mark.name}",
        snippet = "Marker in ${mark.name}"
    )
}