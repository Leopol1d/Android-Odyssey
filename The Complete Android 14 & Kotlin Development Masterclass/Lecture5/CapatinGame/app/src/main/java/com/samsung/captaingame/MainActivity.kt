package com.samsung.captaingame

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.samsung.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame(this)
                }
            }
        }
    }
}

@Composable
fun CaptainGame(context: Context) {
    val treasuresFound = remember{ mutableStateOf(0) }
    val stormOccurred = remember { mutableStateOf(0) }
    val hp = remember { mutableStateOf(100) }
    val direction =  remember{ mutableStateOf("North") }
    val gameOver = remember{ mutableStateOf(false) }
    if (hp.value <= 0 && !gameOver.value) {
        gameOver.value = true
    }
    if (gameOver.value) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Game Over! Score: ${treasuresFound.value * 100}")
            Button(onClick = {
                treasuresFound.value = 0
                stormOccurred.value = 0
                hp.value = 100
                gameOver.value = false
            }) {
                Text("Restart")
            }
        }
    }
    else {
        Column {
            Text(text = "Treasures Found: ${treasuresFound.value}")
            Text(text = "Storm Occurred: ${stormOccurred.value}")
            Text(text = "Current Direction:  ${direction.value}")
            Text(text = "HP ${hp.value}")
            Button(onClick = {
                direction.value = "East"
                if (Random.nextDouble() < 0.2) {
                    stormOccurred.value += 1
                    Toast.makeText(context, "Storm Ahead!", Toast.LENGTH_SHORT).show()
                    hp.value -= 50
                } else if (Random.nextDouble() < 0.5) {
                    treasuresFound.value += 1
                    Toast.makeText(context, "Treasure Found!", Toast.LENGTH_SHORT).show()
                    hp.value += 1
                } else {
                    hp.value += 2
                }
            }) {
                Text("Sail East")
            }
            Button(onClick = {
                direction.value = "West"
                if (Random.nextDouble() < 0.2) {
                    stormOccurred.value += 1
                    Toast.makeText(context, "Storm Ahead!", Toast.LENGTH_SHORT).show()
                    hp.value -= 50
                } else if (Random.nextDouble() < 0.5) {
                    treasuresFound.value += 1
                    Toast.makeText(context, "Treasure Found!", Toast.LENGTH_SHORT).show()
                    hp.value += 1
                } else {
                    hp.value += 2
                }
            }) {
                Text("Sail West")
            }
            Button(onClick = {
                direction.value = "North"
                if (Random.nextDouble() < 0.2) {
                    stormOccurred.value += 1
                    Toast.makeText(context, "Storm Ahead!", Toast.LENGTH_SHORT).show()
                    hp.value -= 50
                } else if (Random.nextDouble() < 0.5) {
                    treasuresFound.value += 1
                    Toast.makeText(context, "Treasure Found!", Toast.LENGTH_SHORT).show()
                    hp.value += 1
                } else {
                    hp.value += 2
                }
            }) {
                Text("Sail North")
            }
            Button(onClick = {
                direction.value = "South"
                if (Random.nextDouble() < 0.2) {
                    stormOccurred.value += 1
                    Toast.makeText(context, "Storm Ahead!", Toast.LENGTH_SHORT).show()
                    hp.value -= 50
                } else if (Random.nextDouble() < 0.5) {
                    treasuresFound.value += 1
                    Toast.makeText(context, "Treasure Found!", Toast.LENGTH_SHORT).show()
                    hp.value += 1
                } else {
                    hp.value += 2
                }
            }) {
                Text("Sail South")
            }
        }
    }
}
