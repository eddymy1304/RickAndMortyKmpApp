package com.eddymy1304.rickandmortykmpapp.data

import com.eddymy1304.rickandmortykmpapp.data.remote.ApiService
import com.eddymy1304.rickandmortykmpapp.domain.RickAndMortyRepository
import com.eddymy1304.rickandmortykmpapp.domain.mapper.toDomain
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel

class RickAndMortyRepositoryImpl(private val apiService: ApiService) : RickAndMortyRepository {
    override suspend fun getSingleCharacter(id: Int): CharacterModel {
        return apiService
            .getSingleCharacter(id = id)
            .toDomain()
    }
}