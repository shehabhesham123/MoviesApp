package com.example.moviesapp.core.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.moviesapp.feature.auth.credential.Authenticator

/**
 * empty activity to determine what the next activity (login activity or main activity)
 */
class RouteActivity : ComponentActivity() {
    private val navigation by lazy { Navigation(Authenticator()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigation.nextActivity(baseContext)
    }
}