package com.abraham.superherobook

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun MainScreen(superheros:ArrayList<Superhero>, navController: NavController){
    SuperheroList(superheros = superheros, navController)
}
