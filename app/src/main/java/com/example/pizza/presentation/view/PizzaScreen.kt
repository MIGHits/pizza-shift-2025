package com.example.pizza.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pizza.R
import com.example.pizza.common.URL.BASE_URL
import com.example.pizza.data.entity.Pizza
import com.example.pizza.presentation.viewModel.PizzaViewModel
import com.example.pizza.ui.theme.Text_Primary

@Composable
fun PizzasScreen(viewModel: PizzaViewModel) {
    viewModel.getPizzasCatalog()
    val scrollState = rememberLazyListState()
    val catalog = viewModel.catalog.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .padding(top = 32.dp, start = 18.dp, end = 16.dp, bottom = 24.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = stringResource(R.string.pizza_header),
                color = Text_Primary,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default,
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .padding(bottom = 54.dp)
                .fillMaxSize()
        ) {
            catalog.value?.let { items(it.catalog) { PizzaCard(it) } }
        }
    }
}

@Composable
fun PizzaCard(pizza: Pizza) {
    Box(
        modifier = Modifier.wrapContentSize()
    ) {
        Row {
            AsyncImage(
                model = BASE_URL + pizza.img,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 12.dp)
                    .wrapContentSize().fillMaxSize(0.4f)

            )
            Spacer(Modifier.size(24.dp))
            Column(modifier = Modifier.padding(end = 16.dp)) {
                Text(
                    text = pizza.name,
                    color = Text_Primary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = pizza.description,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "от " + pizza.sizes.first().price.toString(),
                    color = Text_Primary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp,
                )
            }
        }
    }
}