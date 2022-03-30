package com.sirdave.sosapp.network

import retrofit2.http.Body
import retrofit2.http.POST

interface ContactService {
    @POST("api/v1/create")
    suspend fun submitRequest(@Body request: Request): Response
}