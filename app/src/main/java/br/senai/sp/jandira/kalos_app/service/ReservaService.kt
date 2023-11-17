package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.BaseResponseReservas
import br.senai.sp.jandira.kalos_app.model.ReservaResponse
import com.google.gson.JsonObject
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ReservaService {
    @GET("kalos/reserva/idAluno/{idAluno}/idAcademia/{idAcademia}")
    suspend fun getReservasAluno(@Path("idAcademia") idAcademia: String, @Path("idAluno") idAluno: String): Response<BaseResponseReservas<ReservaResponse>>

    @PUT("kalos/reserva/id/{idReserva}")
    suspend fun updateReserva(@Path("idReserva") idReserva: String, @Body body: JsonObject): Response<JsonObject>
}