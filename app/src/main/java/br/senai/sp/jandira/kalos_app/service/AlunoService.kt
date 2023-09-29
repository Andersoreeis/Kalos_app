package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.model.BaseResponse
import br.senai.sp.jandira.kalos_app.model.BaseResponse2
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AlunoService {
    @GET("kalos/aluno/id/{id}")
    suspend fun getAlunoByID(@Path("id") id: String): Response<BaseResponse<AlunoResponse>>

    @GET("kalos/aluno/email/{email}")
    suspend fun getAlunoByEmail(@Path("email") email: String): Response<JsonObject>

    @GET("kalos/aluno")
    suspend fun getAlunos(): Response<BaseResponse<AlunoResponse>>

    @Headers("Content-Type: application/json")
    @POST("kalos/aluno/autenticar")
    suspend fun autenticarAluno(@Body body: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @POST("kalos/aluno")
    suspend fun cadastrarAluno(@Body body: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @PUT("kalos/aluno/id/{id}")
    suspend fun AtualizarAluno(@Body body: JsonObject, @Path("id") id:String): Response<JsonObject>


}