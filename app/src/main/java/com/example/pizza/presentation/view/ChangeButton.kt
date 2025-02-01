package com.example.pizza.presentation.view

import android.net.Uri
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pizza.R
import com.example.pizza.domain.entity.CartItem
import com.example.pizza.ui.theme.Text_Quartenery
import com.google.gson.Gson

@Composable
fun ChangeButton(cartItem: CartItem, navController: NavController, updateToppings: () -> Unit) {
    TextButton(
        onClick = {
            updateToppings()
            navController.navigate(
                "PizzaDetails/${
                    Uri.encode(
                        Gson().toJson(
                            cartItem.pizza
                        )
                    )
                }"
            )
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Text_Quartenery
        ),
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .aspectRatio(3f),
    ) {
        Text(
            text = stringResource(R.string.change_cart_item),
            color = Text_Quartenery,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 14.52.sp,
            textDecoration = TextDecoration.Underline,
        )
    }
}