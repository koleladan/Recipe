package com.compose.recipeapp.recipe.domain.model

import com.compose.recipeapp.recipe.data.remote.dto.ResultDto

data class Recipe (
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result?>
        )