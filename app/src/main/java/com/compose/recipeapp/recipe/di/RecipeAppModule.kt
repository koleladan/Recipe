package com.compose.recipeapp.recipe.di

import com.compose.recipeapp.recipe.data.RecipeApiService
import com.compose.recipeapp.recipe.data.repository.RecipeRepoImp
import com.compose.recipeapp.recipe.domain.repository.RecipeRepo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeAppModule {
    @Provides
    @Singleton
    fun provideRecipeRepo(recipeApiService: RecipeApiService): RecipeRepo {
        return RecipeRepoImp(recipeApiService)
    }

   @Provides
   @Singleton
   fun provideRecipeApiService(): RecipeApiService {
       val moshi = Moshi.Builder()
           .add(KotlinJsonAdapterFactory())
           .build()

       return Retrofit.Builder()
           .baseUrl(RecipeApiService.BASE_URL)
           .addConverterFactory(MoshiConverterFactory.create(moshi))
           .build()
           .create()

   }
}