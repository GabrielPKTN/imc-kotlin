package com.aulasandroid.imc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.imc_app.ui.theme.ImcappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImcappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    LayoutScreen(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun LayoutScreen(modifier: Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource((R.color.cor_app)))
    ) {

        IMCScreen(modifier = Modifier)
        FormScreen(modifier = Modifier)

    }

}

@Composable
fun IMCScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .height(160.dp)
            .background(color = colorResource((R.color.cor_app)))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.bmi),
            contentDescription = "icon bmi",
            modifier = Modifier.size(80.dp).padding(16.dp)
        )

        Text(
            text = "Calculadora de IMC",
            fontSize = 24.sp,
            color = Color(255, 255, 255, 255),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FormScreen(modifier: Modifier) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .background(Color(115, 193, 236, 255))
            .height(300.dp),

    ) {

        Card(modifier = Modifier
            .width(100.dp)
            .height(30.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {


        }

    }

}