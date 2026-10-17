package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

val jaune = Color(0xFFF9E44C)
val vertMenthe = Color(0xFFC3ECD2)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    // 1 = citronnier, 2 = citron, 3 = verre plein, 4 = verre vide
    var etape by rememberSaveable { mutableIntStateOf(1) }
    var nbPressions by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.app_name), fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = jaune)
            )
        }
    ) { padding ->
        val modif = Modifier.padding(padding)

        when (etape) {
            1 -> EtapeCitronnade(
                texte = R.string.texte_citronnier,
                image = R.drawable.lemon_tree,
                description = R.string.desc_citronnier,
                auClic = {
                    etape = 2
                    // le citron doit etre pressé entre 2 et 4 fois
                    nbPressions = (2..4).random()
                },
                modifier = modif
            )

            2 -> EtapeCitronnade(
                texte = R.string.texte_citron,
                image = R.drawable.lemon_squeeze,
                description = R.string.desc_citron,
                auClic = {
                    nbPressions--
                    if (nbPressions == 0) etape = 3
                },
                modifier = modif
            )

            3 -> EtapeCitronnade(
                texte = R.string.texte_verre_plein,
                image = R.drawable.lemon_drink,
                description = R.string.desc_verre_plein,
                auClic = { etape = 4 },
                modifier = modif
            )

            4 -> EtapeCitronnade(
                texte = R.string.texte_verre_vide,
                image = R.drawable.lemon_restart,
                description = R.string.desc_verre_vide,
                auClic = { etape = 1 },
                modifier = modif
            )
        }
    }
}

// image cliquable + texte en dessous, utilisé pour les 4 étapes
@Composable
fun EtapeCitronnade(
    @StringRes texte: Int,
    @DrawableRes image: Int,
    @StringRes description: Int,
    auClic: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = auClic,
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = vertMenthe)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(description),
                modifier = Modifier
                    .width(128.dp)
                    .height(160.dp)
                    .padding(24.dp)
            )
        }
        Spacer(Modifier.height(16.dp))
        Text(stringResource(texte), fontSize = 18.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ApercuCitronnade() {
    LemonadeTheme {
        LemonadeApp()
    }
}