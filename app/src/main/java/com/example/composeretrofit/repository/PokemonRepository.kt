package com.example.composeretrofit.repository

import com.example.composeretrofit.data.remote.PokeApi
import com.example.composeretrofit.data.remote.response.Pokemon
import com.example.composeretrofit.data.remote.response.PokemoneList
import com.example.composeretrofit.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit:Int , offset:Int) : Resource<PokemoneList>{
        val response = try {
            api.getPokemonList(limit,offset)
        }catch (e : Exception){
            return Resource.Error("there is problem")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String) : Resource<Pokemon>{
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e : Exception){
            return Resource.Error("there is problem")
        }
        return Resource.Success(response)
    }
}