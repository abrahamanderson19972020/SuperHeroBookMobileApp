package com.abraham.superherobook

import androidx.compose.runtime.Composable


@Composable
fun MainScreen(superheros:ArrayList<Superhero>){
    SuperheroList(superheros = superheros)
}
