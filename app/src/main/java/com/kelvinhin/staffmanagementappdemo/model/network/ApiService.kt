package com.kelvinhin.staffmanagementappdemo.model.network

import com.kelvinhin.staffmanagementappdemo.model.request.LoginRequest
import com.kelvinhin.staffmanagementappdemo.model.response.LoginResponse
import com.kelvinhin.staffmanagementappdemo.model.response.StaffListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("login")
    suspend fun login(
        @Query("delay") delay: Int = 5,
        @Body loginRequestBody: LoginRequest
    ): LoginResponse

    @GET("users")
    suspend fun getStaffList(@Query("page") page: Int = 1): StaffListResponse
}