package com.compose.recipeapp.recipe.presentation.recipe_list

import com.compose.recipeapp.recipe.domain.model.Recipe
import com.compose.recipeapp.recipe.domain.model.Results

data class RecipeState(
    val recipe: List<Results> = emptyList(),
    val error:String = ""
)
