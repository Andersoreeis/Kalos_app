package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.BaseResponseExercicio
import br.senai.sp.jandira.kalos_app.model.BaseResponseTreinos
import br.senai.sp.jandira.kalos_app.model.ExercicioResponse
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ExercicioService {
    @GET("kalos/exercicioSerieRepeticao/id/{idExercicio}")
    suspend fun getExercicioPorId(@Path("idExercicio") idExercicio: Int): Response<BaseResponseExercicio<ExercicioResponse>>

    @Headers("Content-Type: application/json")
    @POST("kalos/carga")
    suspend fun anotarCarga(@Body body: JsonObject): Response<JsonObject>
}