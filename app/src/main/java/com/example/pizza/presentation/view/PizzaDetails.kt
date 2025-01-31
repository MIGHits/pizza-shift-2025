package com.example.pizza.presentation.view
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.pizza.App
import com.example.pizza.R
import com.example.pizza.common.URL.BASE_URL
import com.example.pizza.data.models.PizzaModel
import com.example.pizza.data.models.PizzaIngredient
import com.example.pizza.ui.theme.Text_Primary
import com.google.gson.Gson


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PizzaDetails(navController: NavController, pizzaJson: String?) {

    val scrollState = rememberLazyListState()
    val pizzaModel = Gson().fromJson(pizzaJson, PizzaModel::class.java)
    var pizzaSize by remember { mutableStateOf(getString(App.instance, R.string.small_size)) }
    val pizzaDough = mutableStateOf(stringResource(R.string.standart_dough))

    LazyColumn(
        modifier = Modifier
            .padding(bottom = 54.dp)
            .fillMaxSize(),
        state = scrollState
    ) {
        item {
            Box(
                modifier = Modifier
                    .padding(top = 12.dp, start = 4.dp, end = 12.dp, bottom = 12.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Row {
                    IconButton(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .align(Alignment.CenterVertically),
                        onClick = { navController.popBackStack() }) {
                        androidx.compose.material.Icon(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = null,
                        )
                    }
                    Text(
                        text = stringResource(R.string.pizza_header),
                        color = Text_Primary,
                        fontSize = 24.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Default,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically)

                    )
                }
            }
            AsyncImage(
                model = pizzaModel.img,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            Text(
                text = pizzaModel.name,
                color = Text_Primary,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)

            )
            Text(
                text = pizzaSize + stringResource(R.string.virgule) + pizzaDough.value,
                color = Text_Primary,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )

            Text(
                text = pizzaModel.description,
                color = Text_Primary,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            PizzaSizeBar(
                changePizzaSize = { newValue -> pizzaSize = newValue }
            )
            Text(
                text = stringResource(R.string.toppings_header),
                color = Text_Primary,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            FlowRow(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                maxItemsInEachRow = 3
            ) {
                pizzaModel.toppings.forEach { topping ->
                    ToppingCard(
                        topping
                    )
                }
            }
        }
    }
}

