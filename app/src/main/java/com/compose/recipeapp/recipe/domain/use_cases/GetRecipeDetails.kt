package com.compose.recipeapp.recipe.domain.use_cases

import com.compose.recipeapp.core.Resource
import com.compose.recipeapp.recipe.domain.model.Results
import com.compose.recipeapp.recipe.domain.repository.RecipeRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetRecipeDetails @Inject constructor(
    private val repository: RecipeRepo
) {
    operator fun invoke(
        token: String,
        id: Int
    ): Flow<Resource<Results>> = flow {
        try {
            emit(Resource.Loading<Results>())
            val recipe = repository.getRecipeDetails(token, id).toResults()
            emit(Resource.Success<Results>(recipe))
        } catch (e: HttpException) {
            emit(Resource.Error<Results>(e.localizedMessage ?: "An error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<Results>("Couldn't reach the server. Check your Internet"))
        }

    }
}