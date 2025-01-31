package com.example.pizza.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getString
import com.example.pizza.App
import com.example.pizza.R

@Composable
fun PizzaSizeBar(changePizzaSize: (text: String) -> Unit) {
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