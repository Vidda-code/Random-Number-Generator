package com.example.randomnumbergenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomnumbergenerator.ui.theme.RandomNumberGeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomNumberGeneratorTheme {
                RandomNumberGeneratorScreen()
            }
        }
    }
}

@Composable
fun MinimumValue(
    modifier: Modifier = Modifier
) {
    var minValue by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .size(width = 150.dp, height = 120.dp)
    ) {
        TextField(
            value = minValue,
            onValueChange = { minValue = it },
            label = { Text("Minimum") },
            singleLine = true
        )
    }

}

@Composable
fun MaximumValue(
    modifier: Modifier = Modifier
) {
    var maxValue by remember { mutableStateOf("") }
Card(
    modifier = Modifier
        .size(width = 150.dp, height = 120.dp)
) {
    TextField(
        value = maxValue,
        onValueChange = { maxValue = it },
        label = { Text("Maximum") },
        singleLine = true
    )
}

}

@Composable
fun GeneratedNumber(modifier: Modifier = Modifier) {
    var generatedNumber by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .size(width = 350.dp, height = 250.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Generated Number",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "18",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun RandomNumberGeneratorScreen(modifier: Modifier = Modifier) {
    var randomNumber by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                    .size(width = 350.dp, height = 420.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
            ),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    MinimumValue()

                    Spacer(modifier = Modifier.weight(1f))

                    MaximumValue()
                }
                Spacer(modifier = Modifier.weight(1f))
                    GeneratedNumber()

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RandomNumberGeneratorPreview() {
    RandomNumberGeneratorTheme {
        RandomNumberGeneratorScreen()
    }
}