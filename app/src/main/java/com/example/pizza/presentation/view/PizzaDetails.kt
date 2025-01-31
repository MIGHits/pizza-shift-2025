package com.example.pizza.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.RippleDefaults
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults.indicatorLine
import androidx.compose.material.ripple
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.core.content.ContextCompat.getString
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.pizza.App
import com.example.pizza.R
import com.example.pizza.common.CONST.COLUMNS_AMOUNT
import com.example.pizza.common.URL.BASE_URL
import com.example.pizza.data.entity.Pizza
import com.example.pizza.data.entity.PizzaIngredient
import com.example.pizza.ui.theme.Secondary_Gray
import com.example.pizza.ui.theme.Text_Primary
import com.google.gson.Gson


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PizzaDetails(navController: NavController, pizzaJson: String?) {

    val scrollState = rememberLazyListState()
    val pizza = Gson().fromJson(pizzaJson, Pizza::class.java)
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
                model = BASE_URL + pizza.img,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            Text(
                text = pizza.name,
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
                text = pizzaSize + ", " + pizzaDough.value,
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
                text = pizza.description,
                color = Text_Primary,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding( bottom = 24.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            SegmentedControl(
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
                pizza.toppings.forEach { topping ->
                    ToppingCard(
                        topping
                    )
                }
            }
        }
    }
}

@Composable
fun SegmentedControl(changePizzaSize: (text: String) -> Unit) {
    val options = listOf(
        stringResource(R.string.pizza_small),
        stringResource(R.string.pizza_medium),
        stringResource(R.string.pizza_large)
    )
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
            .background(Color(0xFFF2F3F5), shape = RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            options.forEachIndexed { index, text ->
                androidx.compose.material3.TextButton(
                    onClick = {
                        selectedIndex = index
                        when (selectedIndex) {
                            0 -> changePizzaSize(getString(App.instance, R.string.small_size))
                            1 -> changePizzaSize(getString(App.instance, R.string.medium_size))
                            2 -> changePizzaSize(getString(App.instance, R.string.size_large))
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(16.dp))
                        .background(if (selectedIndex == index) Color.White else Color.Transparent),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    elevation = null,
                ) {
                    Text(
                        text = text,
                        color = if (selectedIndex == index) Color.Black else Color.Gray,
                        fontWeight = if (selectedIndex == index) FontWeight.Bold else FontWeight.Normal,
                    )
                }
            }
        }
    }
}

@Composable
fun ToppingCard(topping: PizzaIngredient) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp, bottom = 8.dp, end = 5.dp)
            .wrapContentSize()
            .shadow(elevation = 2.dp, clip = true, shape = RoundedCornerShape(16.dp))
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Column {
            AsyncImage(
                model = BASE_URL + topping.img,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentSize()
            )
            Text(
                text = topping.name.name,
                color = Text_Primary,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = topping.cost.toString() + " ₽",
                color = Text_Primary,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}
