package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.BaseResponseCarga
import br.senai.sp.jandira.kalos_app.model.BaseResponseCargas
import br.senai.sp.jandira.kalos_app.model.BaseResponseExercicio
import br.senai.sp.jandira.kalos_app.model.BaseResponseTreinos
import br.senai.sp.jandira.kalos_app.model.CargaResponse
import br.senai.sp.jandira.kalos_app.model.ExercicioResponse
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ExercicioService {
    @GET("kalos/exercicioSerieRepeticao/id/{idExercicio}")
    suspend fun getExercicioPorId(@Path("idExercicio") idExercicio: Int): Response<BaseResponseExercicio<ExercicioResponse>>

    @GET("/kalos/carga/idAluno/{idAluno}/idESR/{idExercicioSerieRepeticao}")
    suspend fun getCargaPorIdAlunoEExercicio(@Path("idAluno") idAluno: Int, @Path("idExercicioSerieRepeticao") idExercicioSerieRepeticao: Int): Response<BaseResponseCargas<CargaResponse>>

    @Headers("Content-Type: application/json")
    @POST("/kalos/carga")
    suspend fun anotarCarga(@Body body: JsonObject): Response<BaseResponseCarga<CargaResponse>>

    @Headers("Content-Type: application/json")
    @PUT("/kalos/carga/id/{id}")
    suspend fun updateCarga(@Body body: JsonObject, @Path("id") id: Int): Response<BaseResponseCarga<CargaResponse>>
}