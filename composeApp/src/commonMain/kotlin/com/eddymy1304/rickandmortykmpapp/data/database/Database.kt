package com.eddymy1304.rickandmortykmpapp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.eddymy1304.rickandmortykmpapp.data.database.dao.UserPreferencesDao
import com.eddymy1304.rickandmortykmpapp.data.database.entity.CharacterEntity

const val DATABASE_NAME = "rick_and_morty_database.db"

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object RickAndMortyConstructor : RoomDatabaseConstructor<RickAndMortyDatabase>

@Database(entities = [CharacterEntity::class], version = 1)
@ConstructedBy(RickAndMortyConstructor::class)
abstract class RickAndMortyDatabase : RoomDatabase() {

    abstract fun getUserPreferencesCharacterDao(): UserPreferencesDao
}