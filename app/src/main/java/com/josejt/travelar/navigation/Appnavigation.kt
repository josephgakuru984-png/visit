package com.josejt.travelar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
// Import your screens here
// import com.josejt.travelar.ui.screens.OnboardingScreen
// import com.josejt.travelar.ui.screens.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding, // The first screen users see
        modifier = modifier
    ) {
        // Define the behavior for the Onboarding Screen
        composable<Screen.Onboarding> {
            OnboardingScreen(
                onFinish = {
                    navController.navigate(Screen.Home) {
                        // Clear the backstack so they can't go back to Onboarding
                        popUpTo(Screen.Onboarding) { inclusive = true }
                    }
                }
            )
        }

        // Define the behavior for the Home Screen
        composable<Screen.Home> {
            HomeScreen(
                onAboutClick = { navController.navigate(Screen.About) }
            )
        }

        // Define the behavior for the About Screen
        composable<Screen.About> {
            AboutScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}