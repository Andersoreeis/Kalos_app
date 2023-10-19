package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.ExercicioResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExercicioService {
    @GET("/kalos/exercicioSerieRepeticao/id/{idExercicio}")
    suspend fun getExercicioPorId(@Path("idExercicio") idExercicio: String): Response<ExercicioResponse>

}