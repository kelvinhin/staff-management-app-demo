package com.kelvinhin.staffmanagementappdemo

import com.kelvinhin.staffmanagementappdemo.mock.MockApiService
import com.kelvinhin.staffmanagementappdemo.mock.MockDataSource
import com.kelvinhin.staffmanagementappdemo.model.data.NetworkStaffManagementRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertEquals

class NetworkStaffManagementRepositoryTest {
    private val repository = NetworkStaffManagementRepository(
        apiService = MockApiService()
    )
    @Test
    fun loginSuccessTest() =
        runTest {
            assertEquals(
                MockDataSource.successLoginResponse,
                repository.login(loginRequestBody = MockDataSource.loginRequest)
            )
        }

    @Test
    fun loginFailTest() =
        runTest {
            assertEquals(
                MockDataSource.failedLoginResponse,
                repository.login(delay = 10, loginRequestBody = MockDataSource.loginRequest)
            )
        }

    @Test
    fun getStaffListTest() =
        runTest {
            assertEquals(
                MockDataSource.staffList,
                repository.getStaffList(page = 1)
            )
        }
}