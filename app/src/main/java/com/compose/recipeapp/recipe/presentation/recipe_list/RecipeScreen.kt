package com.compose.recipeapp.recipe.presentation.recipe_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun RecipeScreen(
    navigator: DestinationsNavigator,
    viewModel: RecipeViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Column (modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()
        ) {
            items(state.recipe) {result->
                RecipeItem(
                    navigator,
                    results = result
                )

            }

        }
        
    }

}