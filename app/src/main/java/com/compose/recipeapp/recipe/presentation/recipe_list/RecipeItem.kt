package com.compose.recipeapp.recipe.presentation.recipe_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.compose.recipeapp.recipe.domain.model.Recipe
import com.compose.recipeapp.recipe.domain.model.Results
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Destination
fun RecipeItem(
    navigator: DestinationsNavigator,
    results: Results,
    modifier: Modifier = Modifier

){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(10)),
        backgroundColor = Color.LightGray,
        elevation = 4.dp,
        onClick = {
            //TODO
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = results.featured_image,
                contentDescription = "recipe's image")

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
               results.title?.let {
                   Text(text = it,
                       style = MaterialTheme.typography.body1
                   )


               }


            }


        }


    }

}