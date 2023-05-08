package com.compose.recipeapp.recipe.data

import com.compose.recipeapp.recipe.data.remote.dto.ResultDto
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

    ): RecipeDto

    @GET("get")
    suspend fun getRecipeDetails(
        @Header("Authorization") token: String,
        @Query("id") id: Int

    ):ResultDto
}