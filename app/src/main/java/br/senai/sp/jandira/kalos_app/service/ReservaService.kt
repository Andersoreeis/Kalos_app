package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.BaseResponseReservas
import br.senai.sp.jandira.kalos_app.model.ReservaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ReservaService {
    @GET("kalos/reserva/idAluno/{idAluno}/idAcademia/{idAcademia}")
    suspend fun getReservasAluno(@Path("idAcademia") idAcademia: String, @Path("idAluno") idAluno: String): Response<BaseResponseReservas<ReservaResponse>>
}