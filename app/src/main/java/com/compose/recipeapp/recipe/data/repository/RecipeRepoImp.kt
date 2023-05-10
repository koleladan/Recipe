package com.compose.recipeapp.recipe.data.repository

import com.compose.recipeapp.recipe.data.RecipeApiService
import com.compose.recipeapp.recipe.data.remote.dto.RecipeDto
import com.compose.recipeapp.recipe.data.remote.dto.ResultsDto
import com.compose.recipeapp.recipe.domain.repository.RecipeRepo
import javax.inject.Inject

class RecipeRepoImp @Inject constructor(
    private val recipeApiService: RecipeApiService
): RecipeRepo {
    override suspend fun getRecipe(token: String, page: Int.Companion, query: String): List<RecipeDto> {
        return recipeApiService.getRecipe(token, page, query)
    }

    override suspend fun getRecipeDetails(token: String, id: Int): ResultsDto {
        return recipeApiService.getRecipeDetails(token, id)
    }
}