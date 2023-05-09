package com.compose.recipeapp.recipe.data

import com.compose.recipeapp.recipe.data.remote.dto.ResultsDto
import com.compose.recipeapp.recipe.data.remote.dto.RecipeDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeApiService {
    @GET("search")
    suspend fun getRecipe(
        @Header("Authorization") token:String,
        @Query("page") page: Int,
        @Query("query") query: String

    ): List<RecipeDto>

    @GET("get")
    suspend fun getRecipeDetails(
        @Header("Authorization") token: String,
        @Query("id") id: Int

    ):ResultsDto

    companion object {
        const val BASE_URL = "https://food2fork.ca/api/recipe/"
    }
}