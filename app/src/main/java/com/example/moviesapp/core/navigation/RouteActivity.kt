package com.example.moviesapp.core.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity

/**
 * empty activity to determine what the next activity (login activity or main activity)
 */
class RouteActivity : ComponentActivity() {
    private val navigation by lazy { Navigation() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigation.nextActivity()

    }
}