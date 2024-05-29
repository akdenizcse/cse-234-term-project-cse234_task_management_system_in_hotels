package com.example.taskmanagement.login


import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.azureexp.utils.UserData
import com.example.azureexp.utils.UserRepository
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class LoginViewModel : ViewModel() {
    val loginState = mutableStateOf<ApiResponse<UserData>?>(null)
    val errorState = mutableStateOf<String?>(null)

    fun login(email: String, password: String, navController: NavController, context: Context) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.userRetrofit.login(LoginRequest(email, password)).awaitResponse()
                if (response.isSuccessful) {
                    loginState.value = response.body()
                    val userData  = response.body()?.data
                    UserRepository(context =context).setUserID(userData?.id ?: "")
                    UserRepository(context =context).setBoardID(userData?.boardId ?: "")
                    navController.navigate("DashboardScreen")
                } else {
                    val errorBody = response.errorBody()?.string()
                    errorState.value = "Login failed: ${response.code()} - $errorBody"
                }
            } catch (e: Exception) {
                errorState.value = e.message
            }
        }
    }
}