package com.compose.recipeapp.recipe.domain.use_cases

import com.compose.recipeapp.core.Resource
import com.compose.recipeapp.recipe.data.remote.dto.toRecipe
import com.compose.recipeapp.recipe.domain.model.Recipe
import com.compose.recipeapp.recipe.domain.repository.RecipeRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetAllRecipeList @Inject constructor(
    private val repository: RecipeRepo
) {
    operator fun invoke(
        token: String,
        page: Int.Companion,
        query: String
    ): Flow<Resource<List<Recipe>>> = flow {
        try {
            emit(Resource.Loading<List<Recipe>>())
            val recipe = repository.getRecipe(token,page,query).map { it.toRecipe() }
            emit(Resource.Success<List<Recipe>>(recipe))
        } catch (e:HttpException){
            emit(Resource.Error<List<Recipe>>(e.localizedMessage ?: "An error occurred"))
        }catch (e: IOException) {
            emit(Resource.Error<List<Recipe>>("Couldn't reach the server. Kindly check your internet"))
        }
    }
}