package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.model.BaseResponse
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AlunoService {
    @GET("kalos/aluno/id/{id}")
    suspend fun getAlunoByID(@Path("id") id: String): Response<BaseResponse<AlunoResponse>>

    @GET("kalos/aluno")
    suspend fun getAlunos(): Response<BaseResponse<AlunoResponse>>

    @POST("kalos/aluno/autenticar")
    suspend fun autenticarAluno(@Body body: JsonObject): Response<JsonObject>

    @POST("kalos/aluno")
    suspend fun cadastrarAluno(@Body body: JsonObject): Response<JsonObject>
}