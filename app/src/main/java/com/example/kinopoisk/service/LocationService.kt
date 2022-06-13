package com.example.kinopoisk.service

import android.content.Context
import com.google.android.gms.location.LocationServices

class LocationService(
    private val context: Context
) {

    private val client = LocationServices.getFusedLocationProviderClient(context)


}