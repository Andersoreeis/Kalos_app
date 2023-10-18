package br.senai.sp.jandira.kalos_app.service

import br.senai.sp.jandira.kalos_app.model.BaseResponsePostagem
import br.senai.sp.jandira.kalos_app.model.PostagensResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostagemService {

    @GET("kalos/postagem/idAcademia/{idAcademia}")
    suspend fun getTodasPostagens(@Path("idAcademia") idAcademia: String): Response<BaseResponsePostagem<PostagensResponse>>
}