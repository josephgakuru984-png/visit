
package com.josejt.travelar.navigation

import kotlinx.serialization.Serializable

// Using a sealed interface keeps all screens grouped together
sealed interface Screen {
    @Serializable
    object Onboarding : Screen

    @Serializable
    object Home : Screen

    @Serializable
    object About : Screen

    // Example of a screen that carries data
    @Serializable
    data class Profile(val userId: String) : Screen
}