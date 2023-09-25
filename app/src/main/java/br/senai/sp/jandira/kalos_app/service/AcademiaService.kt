package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.AcademiaResponse
import br.senai.sp.jandira.kalos_app.model.AlunoResponse
import br.senai.sp.jandira.kalos_app.model.BaseResponse
import br.senai.sp.jandira.kalos_app.model.BaseResponse2
import br.senai.sp.jandira.kalos_app.model.BaseResponseAcademia
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface AcademiaService {

    @GET("kalos/academia/nome/{nomes}")
    suspend fun getAlunoByNome(@Path("nomes") id: String): Response<BaseResponseAcademia<AcademiaResponse>>

}