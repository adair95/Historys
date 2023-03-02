package com.example.historias

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.*
import androidx.compose.ui.res.stringResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.historias.ui.theme.HistoriasTheme


 val listadoDeNombres: List<MisDatos> = listOf(
     MisDatos("Adair"),
     MisDatos("Miguel"),
     MisDatos("Katia"),
     MisDatos("Vanesa"),
     MisDatos("Adair"),
     MisDatos("Miguel"),
     MisDatos("Katia"),
     MisDatos("Vanesa"),
 )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HistoriasTheme {
                // A surface container using the 'background' color from the theme

                Surface {
                   Greeting(listadoDeNombres)

                }
            }
        }
    }
}

data class MisDatos(val nombre: String)

@Composable
fun  Greeting(msg: List<MisDatos>):Unit {
    SearChBar()
    LazyRow(){
        items(msg){
            listado ->  Compomente(listado)
        }
    }
}

@Composable
fun SearChBar(
    modifier: Modifier = Modifier
){

    Row() {
        TextField(
            value = "",
            onValueChange ={},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background
            ),
            placeholder = {
                Text(stringResource(id = R.string.placeholder_search))
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 6.dp)
        )
    }
}
@Composable
fun Compomente(nombre: MisDatos){

    AlignYourBodyElement(
        drawable = R.drawable.inversion,
        modifier = Modifier.padding(8.dp),
        nombre
    )

}
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    //@StringRes text: Int,
    modifier: Modifier = Modifier,
    nombre: MisDatos

){

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {

        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            nombre.nombre,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}


@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun DefaultPreview() {
    HistoriasTheme {
        Greeting(listadoDeNombres)
    }
}