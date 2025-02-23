package com.eddymy1304.rickandmortykmpapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform