package com.example.pizza.presentation.view

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pizza.R
import com.example.pizza.ui.theme.Active_Icon
import com.example.pizza.ui.theme.InActive_Icon
import com.example.pizza.ui.theme.Text_Primary

@Composable
fun BottomNavigationBar(navController: NavController) {
    val listItems = listOf(
        BottomNavigationItem.pizzaScreen,
        BottomNavigationItem.orderScreen,
        BottomNavigationItem.cartScreen,
        BottomNavigationItem.profileScreen
    )

    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon), contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 10.sp,
                        lineHeight = 11.72.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Default,
                        textAlign = TextAlign.Center
                    )
                },
                selectedContentColor = Active_Icon,
                unselectedContentColor = InActive_Icon
            )
        }
    }
}