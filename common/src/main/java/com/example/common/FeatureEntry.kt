package com.example.common

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable

typealias Destinations = Map<Class<out FeatureEntry>, @JvmSuppressWildcards FeatureEntry>

/** Interface that describe
    an entry point of feature
*/
interface FeatureEntry {

    val featureRoute: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}

/**
 * Interface that describe
 * a single composable entry point
 */
interface ComposableFeatureEntry: FeatureEntry {

    /**
     * Analog of standard composable fun
     */
    fun NavGraphBuilder.composable(
        navController: NavController,
        destinations: Destinations
    ) {
        composable(
            route = featureRoute,
            arguments = arguments,
            deepLinks = deepLinks
        ) {
            Composable(
                navController = navController,
                destinations = destinations,
                backStackEntry = it
            )
        }
    }

    /**
     * Realization of feature screen
     */
    @Composable
    fun NavGraphBuilder.Composable(
        navController: NavController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    )
}

/**
 * Interface that describe
 * nested composable nav graph
 */
interface AggregateFeatureEntry : FeatureEntry {

    fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    )
}

/**
 * Get instance of destination
 */
inline fun <reified T : FeatureEntry> Destinations.find(): T =
    findOrNull() ?: error("Unable to find '${T::class.java}' destination.")

inline fun <reified T : FeatureEntry> Destinations.findOrNull(): T? =
    this[T::class.java] as? T