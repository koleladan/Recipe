package com.compose.recipeapp.recipe.presentation.recipe_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.recipeapp.core.Resource
import com.compose.recipeapp.recipe.domain.model.Results
import com.compose.recipeapp.recipe.domain.use_cases.GetAllRecipeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val getAllRecipeList: GetAllRecipeList
): ViewModel() {
    private val _state = mutableStateOf(RecipeState())
    var state: State<RecipeState> = _state

    init {
        getRecipe(token = String(), page = Int, query = String())
    }


    private fun getRecipe(token: String, page: Int.Companion, query: String) {
        getAllRecipeList(token, page, query).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = RecipeState(recipe = (result.data ?: emptyList()) as List<Results>)

                }
                is Resource.Error -> {
                    _state.value = RecipeState(error = result.message ?: "An error occurred")

                }
                is Resource.Loading -> {
                    _state.value = RecipeState()

                }
            }
        }.launchIn(viewModelScope)

    }
}