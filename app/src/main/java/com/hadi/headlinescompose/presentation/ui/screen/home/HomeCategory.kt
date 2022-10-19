package com.hadi.headlinescompose.presentation.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hadi.headlinescompose.presentation.ui.theme.Black
import com.hadi.headlinescompose.presentation.ui.theme.Calisto
import com.hadi.headlinescompose.presentation.ui.theme.PrimaryRed
import com.hadi.headlinescompose.presentation.ui.theme.White


@Composable
fun HomeCategory(
    modifier: Modifier = Modifier,
    categories: List<String>,
    onCategorySelected: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Black)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .height(50.dp)
                .background(PrimaryRed)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,

            ) {
            categories.forEach { category ->
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Text(
                    text = category,
                    fontFamily = Calisto,
                    fontSize = 20.sp,
                    color = White
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Black)
        )
    }

}

@Preview
@Composable
fun HomeCategoryPreview(
    categories: List<String> = listOf("Category", "Science", "Technology")
) {
    HomeCategory(categories = categories, onCategorySelected = {})
}