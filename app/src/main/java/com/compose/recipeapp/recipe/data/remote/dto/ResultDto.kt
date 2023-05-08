package com.compose.recipeapp.recipe.data.remote.dto

import com.compose.recipeapp.recipe.domain.model.Result
import com.google.gson.annotations.SerializedName

data class ResultDto(
    val cooking_instructions: String,
    val date_added: String,
    val date_updated: String,
    val description: String,
    val featured_image: String,
    val ingredients: List<String>,
    val long_date_added: Int,
    val long_date_updated: Int,
    val pk: Int,
    val publisher: String,
    val rating: Int,
    val source_url: String,
    val title: String
) {
    fun toResult(): Result {
        return Result(
            cooking_instructions = cooking_instructions,
            date_added = date_added,
            date_updated = date_updated,
            description = description,
            featured_image = featured_image,
            ingredients = ingredients,
            long_date_added = long_date_added,
            long_date_updated = long_date_updated,
            id = pk,
            publisher = publisher,
            rating = rating,
            source_url = source_url,
            title = title


        )

    }
}