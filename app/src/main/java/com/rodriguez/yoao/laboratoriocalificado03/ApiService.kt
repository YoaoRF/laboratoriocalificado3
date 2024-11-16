package com.rodriguez.yoao.laboratoriocalificado03

import retrofit2.http.GET

interface ApiService {
    @GET("list/teacher")
    suspend fun getTeachers(): List<Teacher>
}
