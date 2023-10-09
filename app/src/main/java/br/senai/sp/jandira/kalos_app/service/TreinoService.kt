package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.AcademiaResponse
import br.senai.sp.jandira.kalos_app.model.BaseResponseTreinos
import br.senai.sp.jandira.kalos_app.model.BaseResponseTreinos2
import br.senai.sp.jandira.kalos_app.model.TreinoComExercicio
import br.senai.sp.jandira.kalos_app.model.TreinosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TreinoService {

    @GET("kalos/treinoNivelCategoria/idAluno/{idAluno}/idAcademia/{idAcademia}")
    suspend fun getTreinosAcademiaAluno(@Path("idAcademia") idAcademia: String, @Path("idAluno") idAluno: String): Response<BaseResponseTreinos<TreinosResponse>>

    @GET("kalos/treinoNivelCategoria/id/{idTreino}")
    suspend fun getTreinoPorId(@Path("idTreino") idTreino: String): Response<BaseResponseTreinos2<TreinoComExercicio>>

}