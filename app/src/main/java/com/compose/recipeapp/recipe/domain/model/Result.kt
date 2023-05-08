package com.compose.recipeapp.recipe.domain.model

import com.google.gson.annotations.SerializedName

data class Result(

    @SerializedName("cooking_instructions")
    val cooking_instructions: String? = null,
    @SerializedName("date_added")
    val date_added: String? = null,
    @SerializedName("date_updated")
    val date_updated: String? =  null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("featured_image")
    val featured_image: String? = null,
    @SerializedName("ingredients")
    val ingredients: List<String>? = null,
    @SerializedName("long_date_added")
    val long_date_added: Int? = null,
    @SerializedName("long_date_updated")
    val long_date_updated: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("publisher")
    val publisher: String? = null,
    @SerializedName("rating")
    val rating: Int? = null,
    @SerializedName("source_url")
    val source_url: String? = null,
    @SerializedName("title")
    val title: String? = null
)
