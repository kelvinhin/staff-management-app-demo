package com.kelvinhin.staffmanagementappdemo.mock

import com.kelvinhin.staffmanagementappdemo.model.network.ApiService
import com.kelvinhin.staffmanagementappdemo.model.request.LoginRequest
import com.kelvinhin.staffmanagementappdemo.model.response.LoginResponse
import com.kelvinhin.staffmanagementappdemo.model.response.StaffListResponse

class MockApiService: ApiService {
    override suspend fun login(delay: Int, loginRequestBody: LoginRequest): LoginResponse {
        return if (delay >= 10) {
            MockDataSource.failedLoginResponse
        } else {
            MockDataSource.successLoginResponse
        }
    }

    override suspend fun getStaffList(page: Int): StaffListResponse {
        return MockDataSource.staffList
    }
}