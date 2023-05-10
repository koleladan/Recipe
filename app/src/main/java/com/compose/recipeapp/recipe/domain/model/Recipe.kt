package com.compose.recipeapp.recipe.domain.model

data class Recipe(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Results>
        )