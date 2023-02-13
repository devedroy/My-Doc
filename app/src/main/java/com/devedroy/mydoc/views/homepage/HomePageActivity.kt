package com.devedroy.mydoc.views.homepage

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.devedroy.mydoc.databinding.ActivityHomePageBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*


class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private val permissionId = 2
    private val TAG = "activity"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLocation()
        configureHospitalAdapter()
        configureDepartmentsAdapter()
        configureTestsAdapter()
    }

    private fun configureDepartmentsAdapter() {
        TODO("Not yet implemented")
    }

    private fun configureTestsAdapter() {
        TODO("Not yet implemented")
    }

    private fun configureHospitalAdapter() {
        val myListData: List<DemoData>? = null //install data from ViewModel

        val mRecyclerDemoAdapter = RecyclerDemoAdapter(this, myListData)
        binding.rvHospitals.adapter = mRecyclerDemoAdapter
        binding.rvHospitals.layoutManager = LinearLayoutManager(this)
    }


    @SuppressLint("MissingPermission", "SetTextI18n")
    private fun getLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) {
                    val location: Location? = it.result
                    if (location != null) {
                        val geocoder = Geocoder(this, Locale.getDefault())
                        val list: kotlin.collections.List<Address> =
                            geocoder.getFromLocation(
                                location.latitude,
                                location.longitude,
                                1
                            ) as List<Address>

                        Log.d(TAG, "latitude ${list[0].latitude}")
                        Log.d(TAG, "longitude ${list[0].longitude}")
                        //binding.apply {
                        /* tvLatitude.text = "Latitude\n${list[0].latitude}"
                         tvLongitude.text = "Longitude\n${list[0].longitude}"
                         tvCountryName.text = "Country Name\n${list[0].countryName}"*/
                        //  tvLocalityShow.text = list[0].locality
                        binding.tvCurrentLocation.text = list[0].getAddressLine(0)

                        //  }

                    }
                }
            } else {
                Toast.makeText(this, "Please turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
    }


    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ),
            permissionId
        )
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == permissionId) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLocation()
            }
        }
    }
}

