package com.example.moviesapp.core.navigation

import android.content.Context
import android.content.Intent
import com.example.moviesapp.feature.auth.credential.Authenticator
import com.example.moviesapp.feature.login.ui.Login

/**
 * this class contains all intent (Explicit & Implicit)
 */
class Navigation(private val auth: Authenticator) {

    fun nextActivity(context: Context) {

        if (auth.isUserLogin()) {

        } else {
            context.startActivity(Intent(context, Login::class.java))
        }
    }
}