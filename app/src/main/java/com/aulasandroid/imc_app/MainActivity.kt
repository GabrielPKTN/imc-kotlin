package com.aulasandroid.imc_app

import android.os.Bundle
import android.util.Log.i
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.imc_app.ui.theme.ImcappTheme
import java.io.DataInput
import kotlin.reflect.typeOf

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
            .background(Color.White)
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
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Card(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .offset(y = (-30).dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {

            DataInput(modifier = Modifier)


        }

    }

}

@Composable
fun DataInput(modifier: Modifier) {

    var resultado by remember {
        mutableStateOf("")
    }

    var altura by remember {
        mutableStateOf("")
    }

    var peso by remember {
        mutableStateOf("")
    }

    Column(

        modifier = Modifier
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Seus dados",
            color = colorResource(R.color.cor_app),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        InputForm(
            modifier = Modifier,
            altura = {altura = it},
            peso = {peso = it},
            resultado = {resultado = it}
        )

        ResultLabel(modifier = Modifier, resultado = {resultado = it})

    }

}

@Composable
fun InputForm(modifier: Modifier,
              altura: (String) -> Unit,
              peso: (String) -> Unit,
              resultado: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        //Inputs de entrada
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(

                value = altura,
                onValueChange = altura,
                singleLine = true,
                placeholder = { Text("Altura") },
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(

                    unfocusedBorderColor = colorResource(R.color.cor_app),

                    focusedBorderColor = colorResource(R.color.cor_app),

                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )

            )

            OutlinedTextField(

                value = peso,
                onValueChange = peso,
                singleLine = true,
                placeholder = { Text("Peso") },
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(

                    unfocusedBorderColor = colorResource(R.color.cor_app),

                    focusedBorderColor = colorResource(R.color.cor_app),

                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )

            )

        }

        Button(
            onClick = {
                var resultadoConta = calculaIMC(altura = altura, peso = peso)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.cor_app)

            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Calcular",
                fontSize = 20.sp
            )
        }

    }

}

@Composable
fun ResultLabel(modifier: Modifier, resultado: (String) -> Unit) {

    Card(modifier = Modifier

        .background(Color(49, 124, 0, 255))

    ) {
        Text(resultado)
    }

}


fun calculaIMC(altura: String, peso: String): String {
    val conta = (peso.toFloat() / (altura.toFloat()*altura.toFloat())).toString()

    return conta
}