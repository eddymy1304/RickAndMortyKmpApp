package com.eddymy1304.rickandmortykmpapp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.eddymy1304.rickandmortykmpapp.data.database.entity.CharacterEntity

@Dao
interface UserPreferencesDao {

    @Query("SELECT * FROM character")
    suspend fun getCharacterOfTheDayDb(): CharacterEntity?

}