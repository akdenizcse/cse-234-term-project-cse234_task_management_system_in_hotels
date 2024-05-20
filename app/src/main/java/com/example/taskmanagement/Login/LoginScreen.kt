package com.example.taskmanagement.Login


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun LoginScreen(navController: NavController) {

    // MutableState'leri tanımla
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome", fontSize = 28.sp, fontWeight = FontWeight.Bold )

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login to your account")
        Spacer(modifier = Modifier.height(16.dp))

        // Email alanı
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email address") }
        )

        Spacer(modifier = Modifier.height(16.dp))

       //Password alanı
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))
            //Login butonu daha sonra buraya parametre ekleyip diğer sayfaya göndercez
        Button(onClick = {
            val call = RetrofitInstance.apiService.login(email, password)
            call.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        navController.navigate("Dashboard/${response.body()?.token}")
                    } else {
                        // Handle error
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }) }){
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Forgot Password? ",
            modifier = Modifier.clickable {  }
        )
    }
}


