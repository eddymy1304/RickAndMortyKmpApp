package com.eddymy1304.rickandmortykmpapp.domain.mapper

interface ResponseToDomainMapper<Response, Domain> {
    fun toDomain(response: Response): Domain

}