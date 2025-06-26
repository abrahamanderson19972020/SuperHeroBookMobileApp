package com.abraham.superherobook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson


@Composable
fun SuperheroRow(superhero: Superhero, navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
            .clickable {
                navController.navigate("details_screen/${Gson().toJson(superhero)}")
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = superhero.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = superhero.universe,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Normal
        )
    }
}