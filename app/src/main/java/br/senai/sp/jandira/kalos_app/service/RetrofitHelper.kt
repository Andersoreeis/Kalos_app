package br.senai.sp.jandira.kalos_app.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = "https://kaloscorp.cyclic.cloud/"
    private const val BASE_URL2 = "http://10.107.144.11:8080/"
    private const val BASE_URL3 = "http://10.107.144.2:8080/"

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}