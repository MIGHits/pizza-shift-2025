package com.example.pizza.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pizza.domain.entity.Ingredient
import com.example.pizza.presentation.viewModel.PizzaViewModel
import com.example.pizza.ui.theme.Text_Primary

@Composable
fun ToppingCard(
    topping: Ingredient,
    selectedToppings: List<Ingredient>,
    addTopping: (topping: Ingredient) -> Unit,
    removeTopping: (topping: Ingredient) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp, bottom = 8.dp, end = 5.dp)
            .wrapContentSize()
            .shadow(
                elevation = 2.dp,
                clip = true,
                shape = RoundedCornerShape(16.dp)
            )
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = if (selectedToppings.contains(topping)) {
                    Color.Red
                } else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = {
                if (selectedToppings.contains(topping)) {
                    removeTopping(topping)
                } else {
                    addTopping(topping)
                }
            })
    ) {
        Column {
            AsyncImage(
                model = topping.img,
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