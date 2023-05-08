package com.compose.recipeapp.recipe.data.remote.dto

import com.compose.recipeapp.recipe.domain.model.Recipe

data class RecipeDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ResultDto>
)
fun RecipeDto.toRecipe(): Recipe{
    return Recipe(
        count = count,
        next = next,
        previous = previous,
        results = results.map {it.toResult()}
    )
}