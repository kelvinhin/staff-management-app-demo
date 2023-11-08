package com.kelvinhin.staffmanagementappdemo.model.data

import com.kelvinhin.staffmanagementappdemo.model.network.ApiService
import com.kelvinhin.staffmanagementappdemo.model.request.LoginRequest
import com.kelvinhin.staffmanagementappdemo.model.response.LoginResponse
import com.kelvinhin.staffmanagementappdemo.model.response.StaffListResponse

interface StaffManagementRepository {
    suspend fun login(delay: Int = 5, loginRequestBody: LoginRequest): LoginResponse
    suspend fun getStaffList(page: Int): StaffListResponse
}

class NetworkStaffManagementRepository(
    private val apiService: ApiService
): StaffManagementRepository {
    override suspend fun login(delay: Int, loginRequestBody: LoginRequest): LoginResponse {
        return apiService.login(delay, loginRequestBody)
    }

    override suspend fun getStaffList(page: Int): StaffListResponse {
        return apiService.getStaffList(page)
    }

}