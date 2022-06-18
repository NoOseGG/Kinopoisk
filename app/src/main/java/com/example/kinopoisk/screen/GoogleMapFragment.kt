package com.example.kinopoisk.screen

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.kinopoisk.R
import com.example.kinopoisk.databinding.FragmentGoogleMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.properties.Delegates

class GoogleMapFragment : Fragment(), OnMapReadyCallback {

    private var mMap: GoogleMap by Delegates.notNull()
    private val args: GoogleMapFragmentArgs by navArgs()
    private val mapFragment by lazy {
        childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGoogleMapBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        val geoLocation = Geocoder(requireContext())
        val location = geoLocation.getFromLocationName(args.countryName, 5)

        if (!location.isEmpty()) {
            val adress = location.first()
            val country = LatLng(adress.latitude, adress.longitude)
            mMap.addMarker(
                MarkerOptions()
                    .position(country)
                    .title(args.countryName)
            )
            mMap.moveCamera(CameraUpdateFactory.newLatLng(country))
        } else {
            Toast.makeText(requireContext(), "There is no such country", Toast.LENGTH_LONG)
                .show()
        }
    }
}