package br.senai.sp.jandira.kalos_app.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = "https://kaloscorp.cyclic.app/"
    private const val BASE_URL2 = "http://10.107.144.3:8080/" //artur
    private const val BASE_URL3 = "http://10.107.144.4:8080/"  //yasmin

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}