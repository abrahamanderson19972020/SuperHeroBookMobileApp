package com.abraham.superherobook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SuperheroList(superheros:List<Superhero>){
    LazyColumn(
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        items(superheros){
            SuperheroRow(superhero = it)
        }
    }
}