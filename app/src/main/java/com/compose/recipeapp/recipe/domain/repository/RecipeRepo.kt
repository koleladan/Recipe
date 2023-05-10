package com.compose.recipeapp.recipe.domain.repository

import com.compose.recipeapp.recipe.data.remote.dto.RecipeDto
import com.compose.recipeapp.recipe.data.remote.dto.ResultsDto

interface RecipeRepo {
    suspend fun getRecipe(
        token: String,
        page: Int.Companion,
        query: String
    ): List<RecipeDto>

    suspend fun getRecipeDetails(
        token: String,
        id: Int
    ): ResultsDto
}