package com.example.randomnumbergenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomnumbergenerator.ui.theme.DeepViolet
import com.example.randomnumbergenerator.ui.theme.LightLavender
import com.example.randomnumbergenerator.ui.theme.MediumPink
import com.example.randomnumbergenerator.ui.theme.MediumPurple
import com.example.randomnumbergenerator.ui.theme.PalePink
import com.example.randomnumbergenerator.ui.theme.RandomNumberGeneratorTheme
import com.example.randomnumbergenerator.ui.theme.White

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomNumberGeneratorTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Random Number Generator") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = DeepViolet,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    }
                ) { innerPadding ->
                    RandomNumberGeneratorScreen(
                        Modifier
                            .padding(innerPadding),
                        innerPadding
                    )
                }
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
        modifier
            .size(width = 150.dp, height = 120.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightLavender,
        ),
    ) {
        TextField(
            value = minValue,
            onValueChange = { minValue = it },
            label = { Text("Minimum") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = LightLavender,
                focusedContainerColor = LightLavender,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black,
                cursorColor = Color.Black
            )
        )
    }

}

@Composable
fun MaximumValue(
    modifier: Modifier = Modifier
) {
    var maxValue by remember { mutableStateOf("") }
    Card(
        modifier
            .size(width = 150.dp, height = 120.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightLavender,
        ),
    ) {
        TextField(
            value = maxValue,
            onValueChange = { maxValue = it },
            label = { Text("Maximum") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = LightLavender,
                focusedContainerColor = LightLavender,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black,
                cursorColor = Color.Black
            )
        )
    }
}

@Composable
fun GeneratedNumber(modifier: Modifier = Modifier) {
    var generatedNumber by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .size(width = 350.dp, height = 250.dp),
        colors = CardDefaults.cardColors(
            containerColor = MediumPurple,
        ),
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
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = "18",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun RandomNumberGeneratorScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    var randomNumber by remember { mutableStateOf(0) }
    Column(
        modifier
            .fillMaxSize()
            .background(PalePink)
            .padding(top = paddingValues.calculateTopPadding(), bottom = paddingValues.calculateBottomPadding()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Card(
            modifier = Modifier
                .size(width = 350.dp, height = 420.dp),
            colors = CardDefaults.cardColors(
                containerColor = White,
            ),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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

        Spacer(modifier = Modifier.weight(1f))


        Button(
            onClick = { randomNumber = (1..100).random() },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = DeepViolet,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = "Generate Random Number",
                style = MaterialTheme.typography.headlineSmall
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RandomNumberGeneratorPreview() {
    RandomNumberGeneratorTheme {
        RandomNumberGeneratorScreen(
            paddingValues = PaddingValues(16.dp)
        )
    }
}