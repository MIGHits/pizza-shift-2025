package com.example.pizza.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.pizza.R
import com.example.pizza.domain.entity.CartItem
import com.example.pizza.domain.entity.PizzaDough
import com.example.pizza.domain.entity.PizzaSize
import com.example.pizza.presentation.viewModel.PizzaViewModel
import com.example.pizza.ui.theme.Border_Extralight
import com.example.pizza.ui.theme.Text_Primary

@Composable
fun CartItem(cartItem: CartItem, viewModel: PizzaViewModel, navController: NavController) {

    var amount by remember { mutableStateOf(cartItem.amount) }

    LaunchedEffect(cartItem.amount) {
        amount = cartItem.amount
    }

    val counterElements = listOf(
        stringResource(R.string.plus_sign),
        stringResource(R.string.minAmount),
        stringResource(R.string.minus_sign)
    )

    val dough = when (cartItem.selectedDough) {
        PizzaDough.Dough.THIN -> stringResource(R.string.standart_dough)
        PizzaDough.Dough.THICK -> stringResource(R.string.thick_dough)
    }

    val size = when (cartItem.selectedSize) {
        PizzaSize.Size.SMALL -> stringResource(R.string.pizza_small) + " " + stringResource(R.string.small_size)
        PizzaSize.Size.MEDIUM -> stringResource(R.string.pizza_medium) + " " + stringResource(R.string.medium_size)
        PizzaSize.Size.LARGE -> stringResource(R.string.pizza_large) + " " + stringResource(R.string.size_large)
    }

    val price =
        (cartItem.pizza.sizes
            .find { pizzaSize -> pizzaSize.name == cartItem.selectedSize }?.price?.toInt()
            ?: cartItem.pizza.sizes.first().price.toInt()) +
                cartItem.toppings.sumOf { topping -> topping.cost.toInt() }

    Box(
        modifier = Modifier
            .padding()
            .wrapContentSize()
    )
    {
        Row {
            AsyncImage(
                model = cartItem.pizza.img,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 12.dp, top = 24.dp)
                    .wrapContentSize()
                    .fillMaxSize(0.2f)

            )
            Spacer(Modifier.size(24.dp))
            Column(modifier = Modifier.padding(end = 16.dp, top = 24.dp)) {
                Text(
                    text = cartItem.pizza.name,
                    color = Text_Primary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "$size ${stringResource(R.string.virgule)} " +
                            "$dough " +
                            "${if (cartItem.toppings.isNotEmpty()) stringResource(R.string.plus_sign) else ""} " +
                            cartItem.toppings.map { it.name }.joinToString(
                                ", "
                            ),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(modifier = Modifier.padding(bottom = 24.dp, top = 8.dp)) {
                    CounterButton(
                        counterElements,
                        amount,
                        { viewModel.updateCartItem(cartItem.copy(amount = cartItem.amount + 1)) },
                        {
                            viewModel.updateCartItem(cartItem.copy(amount = cartItem.amount - 1))
                        }
                    )
                    ChangeButton(
                        cartItem,
                        navController
                    ) { viewModel.updatePizzaDetails(cartItem) }
                    Text(
                        text = "${price * cartItem.amount} ₽",
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .height(1.dp), color = Border_Extralight
        )
    }
}