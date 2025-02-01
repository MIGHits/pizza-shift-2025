package com.example.pizza.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza.ui.theme.Secondary_Button
import com.example.pizza.ui.theme.Text_Primary

@Composable
fun CounterButton(
    counterElements: List<String>,
    amount: Int,
    increaceAmount: () -> Unit,
    decreaseAmount: () -> Unit,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .aspectRatio(3.5f)
            .background(color = Secondary_Button, shape = RoundedCornerShape(14.dp)),
    ) {
        counterElements.forEachIndexed { index, text ->
            TextButton(
                onClick = {
                    when (index) {
                        0 -> increaceAmount()
                        2 -> decreaseAmount()
                    }
                },
                modifier = Modifier
                    .weight(1f),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = if (index == 1) amount.toString() else text,
                    color = Text_Primary,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    lineHeight = 16.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}