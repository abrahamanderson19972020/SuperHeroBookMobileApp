package com.abraham.superherobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abraham.superherobook.ui.theme.SuperHeroBookTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    private lateinit var superheros: ArrayList<Superhero>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        superheros = getData()
        setContent {
            val navController = rememberNavController()
            SuperHeroBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = "list_screen"){
                            composable("list_screen"){
                                MainScreen(superheros, navController)
                            }

                            composable("details_screen/{superhero}",
                                arguments = listOf(navArgument("superhero"){
                                    type = NavType.StringType
                                })
                            ){
                                val superheroString = remember {
                                    it.arguments?.getString("superhero")
                                }
                                val selectedHero = Gson().fromJson<Superhero>(superheroString, Superhero::class.java)
                                DetailScreen(superhero = selectedHero)
                            }
                        }
                    }
                }
            }
        }
    }

    fun getData(): ArrayList<Superhero> {
        return arrayListOf(
            Superhero(name = "Batman", universe = "Marvel", image = R.drawable.batman),
            Superhero(name = "Captain America", universe = "DC", image = R.drawable.captainamerica),
            Superhero(name = "Hulk", universe = "Marvel", image = R.drawable.hulk),
            Superhero(name = "Robin", universe = "DC", image = R.drawable.robin),
            Superhero(name = "Spiderman", universe = "Marvel", image = R.drawable.spiderman),
            Superhero(name = "Superman", universe = "Marvel", image = R.drawable.superman),
            Superhero(name = "Thor", universe = "Marvel", image = R.drawable.thor)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperHeroBookTheme {

    }
}