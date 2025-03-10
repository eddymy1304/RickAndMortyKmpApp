package com.eddymy1304.rickandmortykmpapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val image: String,
    val selectedDay: String
)